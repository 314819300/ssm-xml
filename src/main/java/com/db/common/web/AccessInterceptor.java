package com.db.common.web;

import java.util.Calendar;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.sql.rowset.serial.SerialException;

import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import com.db.common.exception.ServiceException;

public class AccessInterceptor extends HandlerInterceptorAdapter {
	//适配器模式，你只需要重写你需要的，不需要的就不用了重写了
	//这就是为什么源码中，除了preHandle有返回值，而postHandle和afterCompletion
	/**
	 * 访问控制拦截：早9点之前，晚上6点之后不可访问
	 */
	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		System.out.println("Access");
		//获取当前时间
		long time = System.currentTimeMillis();
		//基于当前时间进行比较
		Calendar c = Calendar.getInstance();
		//修改日历对象的时间
		c.set(Calendar.HOUR_OF_DAY, 9);
		c.set(Calendar.MINUTE, 0);
		c.set(Calendar.SECOND, 0);
		long start = c.getTimeInMillis();
		c.set(Calendar.HOUR_OF_DAY, 18);
		long end = c.getTimeInMillis();
		if(time < start || time > end) {
			throw new ServiceException("当前时间不能访问");
		}
		return true;
		//其实这种使用的是回调方法
	}
}
