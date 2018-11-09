package com.clothing.model.vo;


public interface RetCode {
	
	public int getCode();
	
	public String getMsg();
	
	default boolean success(){
		return getCode() == BaseRetCode.SUCCESS.getCode();
	}
}
