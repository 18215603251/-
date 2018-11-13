package com.cx.mini.boot.kit;

/*
 * 封装, 获取access_token错误信息
 */
public class EntityException {
	
	private String errorcode;
	private String errmsg;
	
	public String getErrorcode() {
		return errorcode;
	}
	public void setErrorcode(String errorcode) {
		this.errorcode = errorcode;
	}
	public String getErrmsg() {
		return errmsg;
	}
	public void setErrmsg(String errmsg) {
		this.errmsg = errmsg;
	}
	
}
