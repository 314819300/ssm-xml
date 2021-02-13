package com.db.common.vo;

import java.io.Serializable;

public class JsonResult implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -4138033536625725437L;
	/**状态码*/
	private int state = 1;//1-success,0-fail
	/**状态信息*/
	private String message = "ok";
	/**正确数据*/
	private Object data;
	
	public JsonResult() {}
	public JsonResult(String message) {
		this.message = message;
	}
	public JsonResult(Object data) {
		this.data = data;
	}
	public JsonResult(Throwable t) {
		this.state = 0;
		this.message = t.getMessage();
	}
	
	public int getState() {
		return state;
	}
	public void setState(int state) {
		this.state = state;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public Object getData() {
		return data;
	}
	public void setData(Object data) {
		this.data = data;
	}
	
}
