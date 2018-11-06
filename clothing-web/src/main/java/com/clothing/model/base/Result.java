package com.clothing.model.base;

import com.clothing.model.base.enums.ResultEnum;

/**
 * 常规ajax post请求返回封装类
 * 
 * @author yangmin
 * @Date:2018年9月29日
 * @param <T>
 */
public class Result {

	private ResultEnum status;
	private String code;
	private Object data;

	public ResultEnum getStatus() {
		return status;
	}

	public void setStatus(ResultEnum status) {
		this.status = status;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public Object getData() {
		return data;
	}

	public void setData(Object data) {
		this.data = data;
	}

}
