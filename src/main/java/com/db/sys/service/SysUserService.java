package com.db.sys.service;
import java.util.Map;

import com.db.common.vo.PageObject;
import com.db.sys.entity.SysUser;
import com.db.sys.vo.SysUserDeptResult;

public interface SysUserService {
	
	int findObjectByColumn(String columnName,String columnValue);
	
	/**
	 * 查询用户以及用户对应的关联信息
	 * @param userId
	 * @return 用户以及部门信息，用户对应的角色信息
	 */
	Map<String, Object> findObjectById(
			Integer userId);
 
	
	/**
	 * 保存用户以及用户和角色的关系数据
	 * @param entity
	 * @param roleIds
	 * @return
	 */
	int updateObject(SysUser entity,Integer[]roleIds);
	 
	/**
	   * 保存用户以及用户和角色的关系数据
	   * @param entity
	   * @param roleIds
	   * @return
	   */
	  int saveObject(SysUser entity,Integer[]roleIds);
	  /**
	   * 禁用启用
	   * @param id
	   * @param valid
	   * @param modifiedUser
	   * @return
	   */
	  int validById(Integer id,Integer valid,String modifiedUser);
      /**
       * 基于条件分页查询用户信息
       * @param username
       * @param pageCurrent
       * @return
       */
	  PageObject<SysUserDeptResult> findPageObjects(
			   String username,
			  Integer pageCurrent);
}
