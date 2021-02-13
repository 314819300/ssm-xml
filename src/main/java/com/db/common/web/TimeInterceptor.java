package com.db.common.web;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

public class TimeInterceptor implements HandlerInterceptor {

	@Override
	public boolean preHandle(HttpServletRequest request, 
			HttpServletResponse response, 
			Object handler)//handler指向了后端控制器
			throws Exception {
		// TODO Auto-generated method stub
		
		System.out.println("time.preHandle");
		long start = System.currentTimeMillis();
		request.setAttribute("start", start);
		return true;//请求是要拦截还是放行，false表示拦截，true放行
	}

	@Override
	public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler,
			ModelAndView modelAndView) throws Exception {
		System.out.println("time.postHandle");
		long end = System.currentTimeMillis();
		long start = (long)request.getAttribute("start");
		long times = end - start;
		System.out.println(">>times>>"+times);
		// TODO Auto-generated method stub
		
	}

	@Override
	public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex)
			throws Exception {
		System.out.println("time.afterCompletion");
		// TODO Auto-generated method stub
		
	}
	
}
