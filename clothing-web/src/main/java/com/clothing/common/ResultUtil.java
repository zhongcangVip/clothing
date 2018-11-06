package com.clothing.common;

import com.clothing.model.base.Result;
import com.clothing.model.base.enums.ResultEnum;

/**
 *  ajax post 返回封状工具类
 * @author yangmin
 * @Date:2018年9月29日
 */
public class ResultUtil {

	public static Result success(Object obj){
		Result result=new Result();
		result.setCode("1");
		result.setData(obj);
		result.setStatus(ResultEnum.SUCCESS);
		return result;
	}
	
	public static Result success(){
		return success(null);
	}
	
	public static Result error(Object obj){
		Result result=new Result();
		result.setCode("0");
		result.setData(obj);
		result.setStatus(ResultEnum.FAIL);
		return result;
	}
	
	public static Result error(){
		return error(null);
	}
	
	public static Result error(String code,Object obj){
		Result result=new Result();
		result.setCode(code);
		result.setData(obj);
		result.setStatus(ResultEnum.FAIL);
		return result;
	}
}
