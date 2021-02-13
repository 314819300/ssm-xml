package com.db.common.aspect;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

/**
 * demo
 * @author acer
 *
 */
@Aspect
@Component
public class OtherAspect {
	
	/**
	 * 切入点：切入扩展功能的一些连接点(JoinPoint)的集合
	 */
	@Pointcut("bean(sysRoleServiceImpl)")
	public void doPointCut() {
		
	}
	/**
	 * 前置通知：核心业务执行之前
	 */
	@Before("doPointCut()")
	public void beforeMethod() {
		System.out.println("@Before");
	}
	
	/**
	 * 后置通知：又称finally通知
	 */
	@After("doPointCut()")
	public void afterMethod() {
		System.out.println("@After");
	}
	
	/**
	 * 成功返回
	 */
	@AfterReturning("doPointCut()")
	public void returnMtthod() {
		System.out.println("@AfterReturning");
	}
	
	/**
	 * 异常
	 */
	@AfterThrowing("doPointCut()")
	public void afterThrowing() {
		System.out.println("@AfterThrowing");

	}
	
	@Around("doPointCut()")
	public Object aroundMethod(ProceedingJoinPoint jp) throws Throwable{
		Object result = null;
		try {
			System.out.println("@Arround before");
			result = jp.proceed();
			System.out.println("@Arround afterreturning");//AfterReturning
			return result;
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println("@Arround afterthrowing");
			throw e;
		} finally {
			System.out.println("@Arround after");
			
		}
		
		

		
	}
}
