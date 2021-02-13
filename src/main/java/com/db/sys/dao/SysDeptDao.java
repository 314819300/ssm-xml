package com.db.sys.dao;
import java.util.List;
import java.util.Map;

import com.db.common.vo.Node;
import com.db.sys.entity.SysDept;
public interface SysDeptDao {
	
	int updateObject(SysDept entity);
	int insertObject(SysDept entity);
	List<Node> findZTreeNodes();
	List<Map<String,Object>> findObjects();
	int getChildCount(Integer id);
	int deleteObject(Integer id);
}
