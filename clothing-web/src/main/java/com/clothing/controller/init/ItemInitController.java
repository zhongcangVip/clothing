package com.clothing.controller.init;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.clothing.common.ResultUtil;
import com.clothing.model.base.Result;

/**
 * 新的商家，商品及相关信息初始化
 * @author yangmin
 * @Date:2018年10月8日
 */
@RequestMapping(value="init")
public class ItemInitController {

	@RequestMapping(value="item")
	@ResponseBody
	public Result initItem(){
		return ResultUtil.success();
	}
	
}
