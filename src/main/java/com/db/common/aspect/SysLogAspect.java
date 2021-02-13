package com.db.common.aspect;

import java.lang.reflect.Method;
import java.util.Arrays;
import java.util.Date;

import org.apache.shiro.SecurityUtils;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.Signature;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.db.common.annotation.RequiredLog;
import com.db.sys.dao.SysLogDao;
import com.db.sys.entity.SysLog;
import com.db.sys.entity.SysUser;

/**
 * 日志切面类，基于此类的对象进行日志行为记录
 * @Aspect 用于描述类，定义此类未切面类型
 * @Service 有的人也习惯性写@Component,这两个一样
 */
@Aspect
@Service
public class SysLogAspect {
	@Autowired
	private SysLogDao sysLogDao;
	/**
	 * 借助@Pointcut定义切入点表达式，切入点
	 * 表示用于告诉底层系统，哪些方法执行时
	 * 要切入扩展功能（例如around）
	 */
//	@Pointcut("bean(sysUserServiceImpl)")
	//如果对所有的service，就需要这样改，但是所有的service就要有一致的类型
//	@Pointcut("bean(*ServiceImpl)")
	//如果我想在某个类的某个方法添加切面该怎么做你，以上这种方法是粗粒度的控制，做不到某个方法的控制
	//那么我们想要控制其中的某个方法，该怎么做呢
	//我们可以自定义注解，然后就可以使用了
	//@annonation 为注解方式的表达式，次表达式可以进行细粒度访问定义
	@Pointcut("@annotation(com.db.common.annotation.RequiredLog)")
	public void doLogPoint() {}
	/**
	 * 使用@Around修饰的方法为一个环绕通知方法
	 * 当方法参数为 ProceedingJoinPoint 类型时，
	 * 并且希望在方法之前，之后都有功能扩展，
	 * 一般可以借助@Around注解进行修饰
	 * 此方法何时执行呢？
	 * 由@Around注解内使用的表达式决定
	 * 其中bean()为一个切入点表达式
	 * 例如bean(sysUserServiceImpl)表示
	 * 当sysUserServiceImpl类中的所有方法执行时
	 * 自动执行如下around方法
	 * @param jp 连接点
	 * @return 返回值，一般返回值为目标方法的执行结果
	 * @throws Throwable 执行业务时返回的异常
	 */
	//bean抽出
	@Around("doLogPoint()")
	public Object around(ProceedingJoinPoint jp) throws Throwable {
//		System.out.println("start : " + System.nanoTime());
		long t1 = System.currentTimeMillis();
		Object result = jp.proceed();//执行目标方法，如果没有这一行，就不会执行目标方法
		long t2 = System.currentTimeMillis();
//		System.out.println("end : " + System.nanoTime());
		//将日志信息(用户日志行为)写入到数据库
		saveLog(jp,(t2-t1));
		
		
		
		
		
		
		return result;
	}
	//原始样子
//	@Around("bean(sysUserServiceImpl)")
//	public Object around(ProceedingJoinPoint jp) throws Throwable {
//		System.out.println("start : " + System.nanoTime());
//		Object result = jp.proceed();//执行目标方法，如果没有这一行，就不会执行目标方法
//		System.out.println("end : " + System.nanoTime());
//		return result;
//	}
	private void saveLog(ProceedingJoinPoint jp, long time) throws NoSuchMethodException, SecurityException {
		//1.获取日志信息
		//1.1获取方法签名信息（记录了慕白方法信息）
		//Signature与MethodSignature在平常使用的还是很多的，私下看一下
//		Signature signature = jp.getSignature();//获取方法签名信息
		MethodSignature signature = (MethodSignature)jp.getSignature();//获取方法签名信息
		//1.2获取目标方法参数类型
		Class<?>[] parameterTypes = signature.getParameterTypes();
		//1.3获取目标方法名字
		String methodName = signature.getName();//获取方法名
		//1.4获取目标方法对象
		Class<?> targetClass = jp.getTarget().getClass();
		//1.5获取类方法信息（类名+"."+方法名）
		String method = targetClass.getName() + "." + methodName;
		System.out.println(method);
		Method targetMethod = null;
		targetMethod = targetClass.getDeclaredMethod(methodName, parameterTypes);
		//1.6获取方法对象上的注解RequiredLog
		RequiredLog requiredLog = targetMethod.getDeclaredAnnotation(RequiredLog.class);//假如使用的是jdk1.8以下，不要使用这个方法，使用getAnnotation
		//1.7获取注解上指定的操作名字
		//现在我们用的是自定义注解，如果是没有该注解的方法，就不能获取到他的value值，就会出错
		//所以这里可以特殊处理
		
		String operation = "";
		if(requiredLog!=null) {
			operation = requiredLog.value();
			
		}
		//1.8获取登陆用户名
		SysLog sysLog = new SysLog();
		SysUser user = (SysUser)SecurityUtils.getSubject().getPrincipal();
		//1.9获取IP地址
		String ip = null;
		//2.封装日志信息
		sysLog.setUsername(user.getUsername());
		sysLog.setIp(ip);
		sysLog.setOperation(operation);//操作名称
		sysLog.setMethod(method);
		sysLog.setParams(Arrays.toString(jp.getArgs()));
		sysLog.setTime(time);
		sysLog.setCreatedTime(new Date());
		
		//3.持久化日志信息
		sysLogDao.insertObject(sysLog);
		
	}
}
