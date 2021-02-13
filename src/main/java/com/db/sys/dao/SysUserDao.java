package com.db.sys.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.db.sys.entity.SysUser;
import com.db.sys.vo.SysUserDeptResult;

public interface SysUserDao {
	
	/**
	 * 基于用户名查找用户信息
	 * @param username
	 * @return
	 */
	SysUser findUserByUserName(String username);

	/**
	 * 分页查询用户
	 * @param username
	 * @param startIndex
	 * @param pageSize
	 * @return
	 */
	List<SysUserDeptResult> findPageObjects(
			@Param("username") String username,
			@Param("startIndex")Integer startIndex,
			@Param("pageSize")Integer pageSize);
	
	/**
	 * 根据username查询总记录数
	 * @param username
	 * @return
	 */
	int getRowCount(@Param("username") String username);
	
	/**
	 * 用户的禁用启用
	 * @param id 用户id
	 * @param valid 禁用启用标志
	 * @param modifiedUser 修改用户
	 * @return
	 */
	int validById(@Param("id") Integer id,
				  @Param("valid") Integer valid,
				  @Param("modifiedUser") String modifiedUser);
	
	/**
	 * 负责将用户信息写入到数据库
	 * @param entity
	 * @return
	 */
	int insertObject(SysUser entity);
	
	/**
	 * 根据id查询用户信息
	 * @param id
	 * @return
	 */
	SysUserDeptResult findObjectById(Integer id);
	
	int getUserCountByDeptId(Integer deptId);
	/**
	 * 基于用户id查找用户以及用户对应的部门信息
	 * @param id 用户id
	 * @return
	 */
}
