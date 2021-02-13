package com.db.sys.entity;

import java.io.Serializable;
import java.util.Date;

public class SysMenu implements Serializable {

	/**
	 * 序列化ID
	 */
	private static final long serialVersionUID = 2764676011573260151L;
	/**菜单id*/
	private Integer id;
	/**菜单名称*/
	private String name;
	/**菜单url*/
	private String url;
	/**菜单类型（两种：2-按钮，1-普通菜单）*/
	private Integer type=1;
	/**排序号*/
	private Integer sort;
	/**备注*/
	private String note;
	/**上级菜单id*/
	private Integer parentId;
	/**菜单对应的权限标识（sys:log:delete）*/
	private String permission;
	/**创建用户*/
	private String createdUser;
	/**修改用户*/
	private String modifiedUser;
	/**创建时间*/
	private Date createdTime;
	/**修改时间*/
	private Date modifiedTime;
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
	public String getUrl() {
		return url;
	}
	public void setUrl(String url) {
		this.url = url;
	}
	public Integer getType() {
		return type;
	}
	public void setType(Integer type) {
		this.type = type;
	}
	public Integer getSort() {
		return sort;
	}
	public void setSort(Integer sort) {
		this.sort = sort;
	}
	public String getNote() {
		return note;
	}
	public void setNote(String note) {
		this.note = note;
	}
	public Integer getParentId() {
		return parentId;
	}
	public void setParentId(Integer parentId) {
		this.parentId = parentId;
	}
	public String getPermission() {
		return permission;
	}
	public void setPermission(String permission) {
		this.permission = permission;
	}
	public String getCreatedUser() {
		return createdUser;
	}
	public void setCreatedUser(String createdUser) {
		this.createdUser = createdUser;
	}
	public String getModifiedUser() {
		return modifiedUser;
	}
	public void setModifiedUser(String modifiedUser) {
		this.modifiedUser = modifiedUser;
	}
	public Date getCreatedTime() {
		return createdTime;
	}
	public void setCreatedTime(Date createdTime) {
		this.createdTime = createdTime;
	}
	public Date getModifiedTime() {
		return modifiedTime;
	}
	public void setModifiedTime(Date modifiedTime) {
		this.modifiedTime = modifiedTime;
	}
	@Override
	public String toString() {
		return "SysMenu [id=" + id + ", name=" + name + ", url=" + url + ", type=" + type + ", sort=" + sort + ", note="
				+ note + ", parentId=" + parentId + ", permission=" + permission + ", createdUser=" + createdUser
				+ ", modifiedUser=" + modifiedUser + ", createdTime=" + createdTime + ", modifiedTime=" + modifiedTime
				+ "]";
	}
	
}
