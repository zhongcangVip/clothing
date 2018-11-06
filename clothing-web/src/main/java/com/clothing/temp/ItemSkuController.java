package com.clothing.temp;

import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.clothing.common.ResultUtil;
import com.clothing.controller.base.BaseController;
import com.clothing.model.base.Pagination;
import com.clothing.model.base.Result;
import com.clothing.model.item.ItemSku;

/**
 * 商品SKU
 * @author yangmin
 * @Date:2018年9月29日
 */
@Controller
@RequestMapping(value="sku")
public class ItemSkuController extends BaseController {

	@RequestMapping(value="list")
	public String list(){
		return null;
	}
	
	@RequestMapping(value="listData")
	@ResponseBody
	public Pagination<ItemSku> listData(){
		return null;
	}
	/**
	 * SK详情
	 * @param model
	 * @return
	 */
	@GetMapping(value="toView")
	public String toView(ModelMap model){
		return "";
	}
	/**
	 * 添加或修改SKU跳转页面
	 * @param model
	 * @return
	 */
	@GetMapping(value="toAddOrEdit")
	public String toAddOrEdit(ModelMap model){
		return "";
	}
	
	/**
	 * 提交 修改与新增操作
	 * @return
	 */
	@RequestMapping(value="submit")
	@ResponseBody
	public Result submit(){
		return ResultUtil.success();
	}
	
	/**
	 * 删除SKU
	 * @return
	 */
	@PostMapping(value="del")
	@ResponseBody	
	public Result delete(){
		return ResultUtil.success();
	}
	
}
