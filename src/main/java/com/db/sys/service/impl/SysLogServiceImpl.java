package com.db.sys.service.impl;

import java.util.List;

import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.db.common.exception.ServiceException;
import com.db.common.vo.PageObject;
import com.db.sys.dao.SysLogDao;
import com.db.sys.entity.SysLog;
import com.db.sys.service.SysLogService;

@Service
public class SysLogServiceImpl implements SysLogService {

	@Autowired
	private SysLogDao sysLogDao;
	
	@Override
	public PageObject<SysLog> findPageObjects(String username, Integer pageCurrent) {
		
		//1.对参数进行有效验证
		if(pageCurrent == null || pageCurrent < 1)
			throw new IllegalArgumentException("当前页码值不正确！");
		
		//2.基于用户名查询总记录数
		int rowCount = sysLogDao.getRowCount(username);
		
		//3.对总记录数进行校验
		if(rowCount == 0)
			throw new ServiceException("没有数据");
		
		//4.基于用户名，当前页码等信息查询当前页记录
		int pageSize = 10;
		int startIndex = (pageCurrent-1)*pageSize;
		List<SysLog> records = 
		sysLogDao.findPageObjects(username, startIndex, pageSize);
		
		//5.封装查询结果
		PageObject<SysLog> po = new PageObject<SysLog>();
		po.setRecords(records);
		po.setRowCount(rowCount);
		po.setPageSize(pageSize);
		po.setPageCurrent(pageCurrent);
		po.setPageCount((rowCount-1)/pageSize+1);
		
		//6.返回结果
		return po;
	}

	/**
	 * 通过@RequiresPermissions注解对如下方法进行描述，表示访问此方法需要进行授权操作，
	 * 认证用户必须具备"sys:log:delete"权限标识才能访问此方法
	 */
	@RequiresPermissions("sys:log:delete")
	@Override
	public int deleteObjects(Integer... ids) {
		
		if(ids == null || ids.length == 0) {
			throw new IllegalArgumentException("请选择一条");
		}
		int rows;
		try {
			rows = sysLogDao.deleteObjects(ids);
		} catch (Throwable e) {
			e.printStackTrace();
			throw new ServiceException("系统出错，正在修复中...");
		}
		if(rows == 0) {
			throw new ServiceException("记录可能不存在了，请刷新后重试");
		}
		return rows;
	}

}
