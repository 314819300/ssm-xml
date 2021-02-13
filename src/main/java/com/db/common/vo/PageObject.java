package com.db.common.vo;

import java.io.Serializable;
import java.util.List;
/**
 * 
 * @author acer
 * VO：Value Object（值对象）：用于封装值
 * 对象存储值一般是利用属性
 * 对象实现业务一般使用方法
 * 
 * @param <T>	参数化类型（泛型）
 */
public class PageObject<T> implements Serializable {
	
	/**序列化ID*/
	private static final long serialVersionUID = -7368493786259905794L;
	
	/**总记录数*/
	private Integer rowCount=0;
	/**页面大小*/
	private Integer pageSize=3;
	/**当前页面值*/
	private Integer pageCurrent=1;
	/**总页数*/
	private Integer pageCount=1;
	/**当前页记录*/
	private List<T> records;
	public Integer getRowCount() {
		return rowCount;
	}
	public void setRowCount(Integer rowCount) {
		this.rowCount = rowCount;
	}
	public Integer getPageSize() {
		return pageSize;
	}
	public void setPageSize(Integer pageSize) {
		this.pageSize = pageSize;
	}
	public Integer getPageCurrent() {
		return pageCurrent;
	}
	public void setPageCurrent(Integer pageCurrent) {
		this.pageCurrent = pageCurrent;
	}
	public Integer getPageCount() {
		return pageCount;
	}
	public void setPageCount(Integer pageCount) {
		this.pageCount = pageCount;
	}
	public List<T> getRecords() {
		return records;
	}
	public void setRecords(List<T> records) {
		this.records = records;
	}
	
	
}
