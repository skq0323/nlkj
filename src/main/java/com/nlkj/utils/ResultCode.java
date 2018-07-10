package com.nlkj.utils;

public enum ResultCode {
	
	SUCCESS(200,"请求成功"),
	WRONGFUL(401,"请求不合法,sign不存在"),
	WARN(400,"请求错误");
	
	private int code;
	private String msg;
	private ResultCode(int code, String msg) {
		this.code = code;
		this.msg=msg;
	}
	public int getCode() {
		return code;
	}
	public String getMsg() {
		return msg;
	}
	
	
	
	

}
