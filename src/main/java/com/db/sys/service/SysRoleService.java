package com.db.sys.service;

import java.util.List;
import java.util.Map;

import com.db.common.vo.CheckBox;
import com.db.common.vo.PageObject;
import com.db.sys.entity.SysRole;
import com.db.sys.vo.SysRoleMenuVo;

public interface SysRoleService {
	
	/**
	 * 获取所有角色的id和name属性值
	 * @return
	 */
	List<CheckBox> findObjects();
//	/**
//	 * 基于角色id获取角色以及角色对应的菜单信息
//	 * @param id
//	 * @return
//	 */
//	SysRoleMenuResult findObjectById(Integer id);
	/**
	 * 保存角色和角色对应的菜单数据
	 * @param entity
	 * @param menuIds
	 * @return
	 */
	int updateObject(SysRole entity,Integer[]menuIds);
	 /**
	  * 保存角色和角色对应的菜单数据
	  * @param entity
	  * @param menuIds
	  * @return
	  */
	 int saveObject(SysRole entity, Integer[] menuIds);
	 /**
	  * 基于角色id删除角色相关信息
	  * @param id
	  * @return
	  */
	 int deleteObject(Integer id);
	 
     /**
      * 通过此方法执行日志分页查询
      * 1)获取总记录数
      * 2)获取当前页的记录
      * 3)计算总页数
      * 4)封装查询结果
      * @param name 查询条件(基于用户名查询日志行为数据)
      * @param pageCurrent 分页条件(当前页的页码值)
      * @return
      */
	 PageObject<SysRole> findPageObjects(
			 String name,
			 Integer pageCurrent);
//	Map<String, Object> findObjectById(Integer id);
	 
	/**
	 * 基于角色id查询name，note以及菜单id
	 * @param id
	 * @return
	 */
	SysRoleMenuVo findObjectById(Integer id);
	
}



