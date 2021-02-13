package com.db.sys.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.db.sys.entity.SysLog;

public interface SysLogDao {
	int insertObject(SysLog entity);
	public List<SysLog> findObjects();
	
	/**
	 * 基于查询条件查询总记录数
	 * 如果不加@Param注解
	 * 在写动态sql时需要用
	 * <if test="_parameter!=null and _parameter!=''">
	 * @param username 查询条件
	 * @return
	 */
	int getRowCount(@Param("username")String username);
	
	/**
	 * 基于查询条件查询当前页面要呈现的数据
	 * @param username
	 * @param startIndex
	 * @param pageSize
	 * @return 当前页数据（日志信息）
	 */
	List<SysLog> findPageObjects(
			@Param("username")String username,
			@Param("startIndex")Integer startIndex,
			@Param("pageSize")Integer pageSize);
	
	/**
	 * 根据id删除对应的记录
	 * @param ids
	 * @return
	 */
	int deleteObjects(@Param("ids")Integer... ids);
}
