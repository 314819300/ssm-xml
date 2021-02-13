package com.db.sys.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.db.common.vo.CheckBox;
import com.db.sys.entity.SysRole;
import com.db.sys.vo.SysRoleMenuVo;

public interface SysRoleDao {

	/**
	 * 查询总记录数
	 * @param name
	 * @return
	 */
	int getRowCount(@Param("name") String name);
	
	/**
	 * 分页查询角色信息
	 * @param name 角色名称
	 * @param startIndex 上一页的结束位置
	 * @param pageSize 每页要查询的条数
	 * @return
	 */
	List<SysRole> findPageObjects(
			@Param("name") String name,
			@Param("startIndex") Integer startIndex,
			@Param("pageSize") Integer pageSize);
	
	/**
	 * 根据id查询角色信息
	 * @param id
	 * @return
	 */
//	SysRole findObjectById(Integer id);
	
	/**
	 * 新增角色
	 * @param entity
	 * @return
	 */
	int insertObject(SysRole entity);
	
	/**
	 * 根据id删除角色
	 * @param id 角色id
	 * @return
	 */
	int deleteObject(Integer id);
	
	/**
	 * 修改角色信息
	 * @param entity
	 * @return
	 */
	int updateObject(SysRole entity);
	
	/**
	 * 查询角色名称，用来给用户分配角色
	 * @return
	 */
	List<CheckBox> findObjects();
	/**
	 * 基于角色id查询角色信息及菜单id
	 * @return
	 */
	SysRoleMenuVo findObjectById(Integer id);
}
