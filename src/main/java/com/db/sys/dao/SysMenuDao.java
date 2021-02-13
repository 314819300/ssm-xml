package com.db.sys.dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;

import com.db.common.vo.Node;
import com.db.sys.entity.SysMenu;

public interface SysMenuDao {
	
	List<String> findPermissions(
			@Param("menuIds")
			Integer[] menuIds);
	
	/**
	 * 查询菜单信息以及上级菜单名称
	 * @return
	 */
	List<Map<String, Object>> findObjects();
	
	/**
	 * 查询zTree呈现菜单数据时
     * 需要的菜单节点信息
	 * @return
	 */
	List<Node> findZtreeMenuNodes();

	/**
	 * 查询子菜单个数
	 * @param id
	 * @return
	 */
	int getChildCount(Integer id);

	/**
	 * 根据id 删除菜单，如果有子菜单，需要先进行子菜单的删除
	 * @param id
	 * @return
	 */
	int deleteObject(Integer id);
	
	/**
	 * 向数据库中插入菜单
	 * @param entity
	 * @return
	 */
	int insertObject(SysMenu entity);
	
	/**
	 * 根据id修改对应的菜单
	 * @param entity
	 * @return
	 */
	int updateObject(SysMenu entity);
}
