package com.db.sys.controller;

import java.util.Map;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.db.common.vo.JsonResult;
import com.db.common.vo.PageObject;
import com.db.sys.entity.SysUser;
import com.db.sys.service.SysUserService;
import com.db.sys.vo.SysUserDeptResult;

@Controller
@RequestMapping("/user/")
public class SysUserController {

	@Autowired
	private SysUserService sysUserService;
	
	@RequestMapping("doLogin")
	@ResponseBody
	public JsonResult doLogin(String username, String password) {
		//1.封装用户名密码信息到token对象
		UsernamePasswordToken token = new UsernamePasswordToken(username, password);
		//2.获取一个Subject对象（主体）
		Subject subject = SecurityUtils.getSubject();
		
		//3.通过Subject次对象提交token对象
		subject.login(token);
		//提交到哪里了？SecurityManager
		//SecurityManager获取token以后会将token传递给认证管理器
		//认账管理器负责对token中的信息进行认证操作
		return new JsonResult("登录成功");
	}

	/** 加载用户管理界面 */
	@RequestMapping("doUserListUI")
	public String doUserListUI() {
		return "sys/user_list";
	}

	/** 加载用户编辑页面 */
	@RequestMapping("doUserEditUI")
	public String doUserEditUI() {
		return "sys/user_edit";
	}

	/**
	 * 分页查询用户信息
	 * 
	 * @param username    用户名
	 * @param pageCurrent 当前页
	 * @return
	 */
	@RequestMapping("doFindPageObjects")
	@ResponseBody
	public JsonResult doFindPageObjects(String username, Integer pageCurrent) {
		PageObject<SysUserDeptResult> pageObject = sysUserService.findPageObjects(username, pageCurrent);
		return new JsonResult(pageObject);
	}

	/**
	 * 对用户尽行禁用启用操作
	 * 
	 * @param id
	 * @param valid
	 * @return
	 */
	@RequestMapping("doValidById")
	@ResponseBody
	public JsonResult doValidById(Integer id, Integer valid) {
		SysUser user = (SysUser)SecurityUtils.getSubject().getPrincipal();
		String username = user.getUsername();
		sysUserService.validById(id, valid, "admin");// "admin"用户将来是登陆用户
		return new JsonResult("update ok");
	}

	@RequestMapping("doSaveObject")
	@ResponseBody
	public JsonResult doSaveObject(SysUser entity, Integer[] roleIds) {
		sysUserService.saveObject(entity, roleIds);
		return new JsonResult("save ok");
	}
	
	/**
	 * 根据用户id查询用户信息及对应的角色
	 * @param userId
	 * @return
	 */
	@RequestMapping("doFindObjectById")
	@ResponseBody
	public JsonResult doFindObjectById(
			Integer id){
		Map<String,Object> map=
		sysUserService.findObjectById(id);
		return new JsonResult(map);
	}
}
