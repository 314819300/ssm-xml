package com.db.sys.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

public interface SysRoleMenuDao {
	
	/**
	 * 根据角色ids查询菜单ids
	 * 为什么多个角色id，因为一个用户可以有多个角色
	 * @param roleIds
	 * @return
	 */
	List<Integer> findMenuIdsByRoleIds(
			@Param("roleIds")Integer[] roleIds);

	/**
	 * 
	 * @param menuId
	 * @return
	 */
	int deleteObjectsByMenuId(Integer menuId);
	
	/**
	 * 
	 * @param roleId
	 * @param menuIds
	 * @return
	 */
	int insertObject(
			@Param("roleId") Integer roleId,
			@Param("menuIds") Integer[] menuIds);
	
	/**
	 * 根据角色id删除角色菜单表中的表关系
	 * @param roleId
	 * @return
	 */
	int deleteObjectByRoleId(Integer roleId);
	
	/**
	 * 根据角色id查询菜单
	 * @param roleId
	 * @return
	 */
	List<Integer> findMenuIdsByRoleId(Integer roleId);
}
