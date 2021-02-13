package com.db.sys.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.db.common.vo.JsonResult;
import com.db.common.vo.PageObject;
import com.db.sys.entity.SysLog;
import com.db.sys.service.SysLogService;
import com.fasterxml.jackson.core.JsonProcessingException;
//import com.fasterxml.jackson.databind.ObjectMapper;

@RequestMapping("/log/")
@Controller
public class SysLogController {

//	1.修饰属性进行赋值
	@Autowired
	private SysLogService sysLogService;

//	2.通过修饰set方法进行赋值
//	private SysLogService sysLogService;
//	@Autowired
//	public void setSysLogService(SysLogService sysLogService) {
//		this.sysLogService = sysLogService;
//	}

//	3.通过构造方法进行赋值
//	@Autowired
//	public SysLogController(SysLogService sysLogService) {
//		System.out.println("通过构造方法注入");
//		this.sysLogService = sysLogService;
//	}

	@RequestMapping("doLogListUI")
	public String doLogListUI() {
		return "sys/log_list";
	}

	/**
	 * @RequestParam 修饰的属性在浏览器上必须传值，并且可以重写属性，@RequestParam("page")
	 *               否则浏览器将报400异常，假如不包含这个属性可以设置@RequestParam(require=false)
	 * @param pageCurrent
	 * @param username
	 * @return
	 * @throws JsonProcessingException 
	 */
	@RequestMapping(value = "doFindPageObjects", method = { RequestMethod.POST, RequestMethod.GET })
	@ResponseBody
	public JsonResult doFindPageObjects(@RequestParam Integer pageCurrent,
			@RequestParam(required = false) String username) {
//		System.out.println("pageCurrent= "+pageCurrent);
		PageObject<SysLog> findPageObjects = sysLogService.findPageObjects(username, pageCurrent);
		return new JsonResult(findPageObjects);
	}
//	@RequestMapping(value = "doFindPageObjects", method = { RequestMethod.POST, RequestMethod.GET },produces = "application/json;charset=utf-8")
//	@ResponseBody
//	public String doFindPageObjects(@RequestParam Integer pageCurrent,
//			@RequestParam(required = false) String username) throws JsonProcessingException {
//		PageObject<SysLog> findPageObjects = sysLogService.findPageObjects(username, pageCurrent);
//		JsonResult jsonResult = new JsonResult(findPageObjects);
//		
//		ObjectMapper objectMapper = new ObjectMapper();
//		String str = objectMapper.writeValueAsString(jsonResult);
//		return str;
//	}

	/**
	 * 根据ids删除对应的记录
	 * 
	 * @param ids
	 * @return
	 */
	@RequestMapping("doDeleteObjects")
	@ResponseBody
	public JsonResult doDeleteObjects(Integer... ids) {
		System.out.println(sysLogService.getClass().getName());//此处这样写是为了是系统底层调用了验证shiro框架中的代理对象
		Integer[] a = ids;
		for (Integer integer : a) {
			System.out.println(integer.intValue());
		}
		sysLogService.deleteObjects(ids);
		return new JsonResult("delete ok!");
	}
}
