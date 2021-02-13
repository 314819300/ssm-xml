package com.db.sys.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

public interface SysUserRoleDao {

	/**
	 * 根据角色id删除用户角色表中的表关系
	 * @param roleId
	 * @return
	 */
	int deleteObjectByRoleId(Integer roleId);
	
	/**
	 * 负责将用户与角色关系写入到数据骷
	 * @param userId
	 * @param roleIds
	 * @return
	 */
	int insertObject(@Param("userId") Integer userId,
					 @Param("roleIds") Integer[] roleIds);
	
	/**
	 * 根据用户id查询对应的角色
	 * @param id
	 * @return
	 */
	List<Integer> findRoleIdsByUserId(Integer id);
}
