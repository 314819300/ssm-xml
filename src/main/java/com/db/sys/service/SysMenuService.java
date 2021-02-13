package com.db.sys.service;
import java.util.List;
import java.util.Map;

import com.db.common.vo.Node;
import com.db.sys.entity.SysMenu;
public interface SysMenuService {
	
	/**
	 * 将菜单信息更新到数据库
	 * @param entity
	 * @return
	 */
	int updateObject(SysMenu entity);
	
	 /**
	  * 将菜单信息保存到数据库
	  * @param entity
	  * @return
	  */
	 int saveObject(SysMenu entity);
	 
	
	 List<Node> findZtreeMenuNodes();
	
	 List<Map<String,Object>> findObjects();
	 /**
	  * 基于菜单id删除菜单以及菜单与角色的关系数据
	  * @param id
	  * @return
	  */
	 int deleteObject(Integer id);
	 
	 
}
