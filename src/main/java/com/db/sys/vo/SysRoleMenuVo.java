package com.db.sys.vo;

import java.util.List;

/**
 * 定义值对象用于封装角色和菜单数据，
 * 可以基于角色id查询角色和菜单数据
 * 然后封装到此对象
 * 
 * @author acer
 *
 */
public class SysRoleMenuVo {

	/**
	 * 角色id
	 */
	private Integer id;
	/**
	 * 角色名称
	 */
	private String name;
	/**
	 * 角色备注
	 */
	private String note;
	/**
	 * 菜单id
	 */
	private List<Integer> menuIds;
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
	public String getNote() {
		return note;
	}
	public void setNote(String note) {
		this.note = note;
	}
	public List<Integer> getMenuIds() {
		return menuIds;
	}
	public void setMenuIds(List<Integer> menuIds) {
		this.menuIds = menuIds;
	}
	@Override
	public String toString() {
		return "SysRoleMenuVo [id=" + id + ", name=" + name + ", note=" + note + ", menuIds=" + menuIds + "]";
	}
	
	
}
