package com.clothing.controller.item;

import java.util.HashMap;
import java.util.Map;

import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.clothing.common.ResultUtil;
import com.clothing.controller.base.BaseController;
import com.clothing.model.base.Pagination;
import com.clothing.model.base.Result;
import com.clothing.model.base.enums.StatusEnum;
import com.clothing.model.item.ItemCategory;
import com.clothing.service.ItemCategoryService;

/**
 * 商品类别信息
 * @author yangmin
 * @Date:2018年10月25日
 */
@Controller
@RequestMapping(value="itemCategory")
public class ItemCategoryController extends BaseController{
	
	@Autowired
	private ItemCategoryService categoryService;
	
	@RequestMapping(value="list")
	public String list(){
		return "item/itemCategoryList";
	}
	
	@RequestMapping(value="listData")
	@ResponseBody
	public Pagination<ItemCategory> listData(){
		int page=this.getInt("page",0);
		int pageSize=this.getInt("pageSize",15);
		String name=this.getString("name");
		String status=this.getString("status");
		Map<String,Object> params=new HashMap<String,Object>();
		if(StringUtils.isNotBlank(status)){
			params.put("status", status);		
		}
		if(StringUtils.isNotBlank(name)){
			params.put("name", name);
		}
			
		Pagination<ItemCategory> pagination=this.categoryService.getItemCategoryByPagination(page, pageSize, params);
		return pagination;
	}
	
	@RequestMapping(value="toAddOrUpdate")
	public String toAddOrUpdate(ModelMap model){
		String id=this.getString("id");
		if(StringUtils.isNotBlank(id)){
			ItemCategory info=this.categoryService.getItemCategoryById(id);
			model.put("category", info);
		}
		return "item/itemCategoryInfo";
	}
	
	@RequestMapping(value="toView")
	public String toView(ModelMap model){
		String id=this.getString("id");
		ItemCategory category=this.categoryService.getItemCategoryById(id);
		model.put("category", category);
		model.put("openModel", "view");
		return "item/itemCategoryInfo";
	}
	
	/**
	 * 新增或修改操作的保存
	 * @return
	 */
	@RequestMapping(value="submit")
	@ResponseBody
	public Result submit(){
		String id=this.getString("id");
		String code=this.getString("code");
		String name=this.getString("name");
		String parent=this.getString("parent");
		ItemCategory category=null;
		if(StringUtils.isNotBlank(id)){
			category=this.categoryService.getItemCategoryById(id);
			
		}else{
			category=new ItemCategory();
			category.setCode(code);
		}
		category.setName(name);
		category.setStatus(StatusEnum.NORMAL);
		category.setParent(this.categoryService.getItemCategoryById(parent));
		if(StringUtils.isNotBlank(id)){
			this.categoryService.updateItemCategory(category);
		}else{
			this.categoryService.insertItemCategory(category);
		}
		return ResultUtil.success();
	}
	
	/**
	 * 状态修改
	 * @return
	 */
	@RequestMapping(value="updateStatus")
	@ResponseBody
	public Result updateStatus(){
		String id=this.getString("id");
		ItemCategory info=this.categoryService.getItemCategoryById(id);
		if(info!=null && info.getStatus().getKey().equals(StatusEnum.NORMAL.getKey())){
			info.setStatus(StatusEnum.DELETE);
		}else{
			info.setStatus(StatusEnum.NORMAL);
		}
		this.categoryService.updateItemCategory(info);
		return ResultUtil.success();
	}
	
	

}
