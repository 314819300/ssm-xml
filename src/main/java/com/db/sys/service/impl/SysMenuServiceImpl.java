package com.db.sys.service.impl;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import com.db.common.exception.ServiceException;
import com.db.common.vo.Node;
import com.db.sys.dao.SysMenuDao;
import com.db.sys.dao.SysRoleMenuDao;
import com.db.sys.entity.SysMenu;
import com.db.sys.service.SysMenuService;

@Service
public class SysMenuServiceImpl implements SysMenuService {

	@Autowired
	private SysMenuDao sysMenuDao;
	@Autowired
	private SysRoleMenuDao sysRoleMenuDao;

	@Override
	public List<Map<String, Object>> findObjects() {
		// 查询菜单信息
		List<Map<String, Object>> list = sysMenuDao.findObjects();
		// 验证查询结果
		if (list == null || list.size() == 0)
			throw new ServiceException("没有对应的记录");
		// 返回结果
		return list;
	}

	@Override
	public List<Node> findZtreeMenuNodes() {

		return sysMenuDao.findZtreeMenuNodes();
	}

	@Override
	public int deleteObject(Integer id) {
		if (id == null || id <= 0)
			throw new ServiceException("请先选择");
		int count = sysMenuDao.getChildCount(id);
		if (count > 0)
			throw new ServiceException("请先删除子菜单");
		int rows = sysMenuDao.deleteObject(id);
		if (rows == 0)
			throw new ServiceException("记录可能不存在");
		sysRoleMenuDao.deleteObjectsByMenuId(id);
		return rows;
	}

	@Override
	public int saveObject(SysMenu entity) {
		// 1.数据的合法化验证
		if (entity == null)
			throw new ServiceException("保存对象不能为空");
		if (StringUtils.isEmpty(entity.getName()))
			throw new ServiceException("菜单名不能为空");
		// 2.插入数据
		int rows;
		try {
			rows = sysMenuDao.insertObject(entity);
		} catch (Exception e) {
			e.printStackTrace();
			throw new ServiceException("保存失败");
		}
		// 3.返回结果
		return rows;
	}

	@Override
	public int updateObject(SysMenu entity) {
		// 1.合法验证
		if (entity == null)
			throw new ServiceException("保存对象不能为空");
		if (StringUtils.isEmpty(entity.getName()))
			throw new ServiceException("菜单名不能为空");

		// 2.更新数据
		int rows = sysMenuDao.updateObject(entity);
		if (rows == 0)
			throw new ServiceException("记录可能已经不存在");
		// 3.返回数据
		return rows;
	}

}
