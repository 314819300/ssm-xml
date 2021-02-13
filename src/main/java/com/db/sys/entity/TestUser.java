package com.db.sys.entity;

import java.io.Serializable;

public class TestUser implements Serializable {

	/**
	 * 序列化ID
	 */
	private static final long serialVersionUID = 3278253241767806029L;
	
	private Integer id;
	private String name;
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
	@Override
	public String toString() {
		return "TestUser [id=" + id + ", name=" + name + "]";
	}
	
	
	

}
