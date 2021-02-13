package com.db.common.web;

import org.apache.shiro.ShiroException;
import org.apache.shiro.authc.IncorrectCredentialsException;
import org.apache.shiro.authc.LockedAccountException;
import org.apache.shiro.authc.UnknownAccountException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.db.common.vo.JsonResult;

/**
 * 全局异常处理类
 * @author acer
 *
 */

@ControllerAdvice
//@RestControllerAdvice
//@RestController
public class GlobalExceptionHandler {
	
	
	@ExceptionHandler(ShiroException.class)
	@ResponseBody
	public JsonResult doShiroException(ShiroException e) {
		e.printStackTrace();
		JsonResult r = new JsonResult();
		r.setState(0);
		if(e instanceof UnknownAccountException) {
			r.setMessage("账户不存在");
		} else if(e instanceof LockedAccountException) {
			r.setMessage("账户被锁定");
		} else if(e instanceof IncorrectCredentialsException) {
			r.setMessage("密码不正确");
		} else {
			r.setMessage(e.getMessage());
		}
		return r;
	}
	
	
	
	@ExceptionHandler(RuntimeException.class)
	@ResponseBody
	public JsonResult doHandleRuntimeException(RuntimeException e) {
		e.printStackTrace();
		System.out.println("异常: "+e);
		return new JsonResult(e);
		
	}
}
