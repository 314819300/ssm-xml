package com.db.sys.service;

import com.db.common.vo.PageObject;
import com.db.sys.entity.SysLog;

public interface SysLogService {
	 /**
	  * 基于控制层请求执行日志删除操作
	  * @param ids 请求参数
	  * @return 删除的行数
	  * 
	  */
	 int deleteObjects(Integer... ids);
     /**
      * 通过此方法执行日志分页查询
      * 1)获取总记录数
      * 2)获取当前页的记录
      * 3)计算总页数
      * 4)封装查询结果
      * @param username 查询条件(基于用户名查询日志行为数据)
      * @param pageCurrent 分页条件(当前页的页码值)
      * @return
      */
	 PageObject<SysLog> findPageObjects(
			 String username,
			 Integer pageCurrent);
}



