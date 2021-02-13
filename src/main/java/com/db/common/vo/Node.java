package com.db.common.vo;

import java.io.Serializable;

public class Node implements Serializable{
	
	private static final long serialVersionUID = 6169404874469160004L;
	/**菜单ID*/
	private Integer id;
	/**菜单名称*/
	private String name;
	/**上级菜单ID*/
	private Integer parentId;
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Integer getParentId() {
		return parentId;
	}
	public void setParentId(Integer parentId) {
		this.parentId = parentId;
	}
	@Override
	public String toString() {
		return "Node [id=" + id + ", name=" + name + ", parentId=" + parentId + "]";
	}
	
	

}
