package com.clothing.web.controller.item;

import java.util.List;

import org.apache.commons.lang3.StringUtils;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.clothing.common.annotation.Log;
import com.clothing.common.base.AjaxResult;
import com.clothing.common.enums.BusinessType;
import com.clothing.framework.util.ShiroUtils;
import com.clothing.framework.web.base.BaseController;
import com.clothing.framework.web.page.TableDataInfo;
import com.clothing.module.domain.Item;
import com.clothing.module.domain.Itemcategory;
import com.clothing.module.domain.Itemunit;
import com.clothing.module.enums.StatusEnum;
import com.clothing.module.service.IItemService;
import com.clothing.module.service.IItemcategoryService;
import com.clothing.module.service.IItemunitService;
import com.clothing.system.domain.SysUser;

/**
 * 商品 信息操作处理
 * 
 * @author yangmin
 * @date 2018-11-23
 */
@Controller
@RequestMapping("/module/item")
public class ItemController extends BaseController
{
    private String prefix = "module/item";
	
	@Autowired
	private IItemService itemService;
	@Autowired
	private IItemcategoryService categoryService;
	@Autowired
	private IItemunitService unitService;
	
	@RequiresPermissions("module:item:view")
	@GetMapping()
	public String item()
	{
	    return prefix + "/item";
	}
	
	/**
	 * 查询商品列表
	 */
	@RequiresPermissions("module:item:list")
	@PostMapping("/list")
	@ResponseBody
	public TableDataInfo list(Item item)
	{
		SysUser user=ShiroUtils.getUser();
		if(!user.isAdmin()){
			item.setFcu(user.getDeptId()+"");
		}
		startPage();
        List<Item> list = itemService.selectItemList(item);
        list.forEach(obj->{
        	StatusEnum status=StatusEnum.valueOf(obj.getFstatus());
        	obj.setFstatus(status.getDescription());
        });
		return getDataTable(list);
	}
	
	/**
	 * 新增商品
	 */
	@GetMapping("/add")
	public String add(ModelMap model)
	{
		SysUser user=ShiroUtils.getUser();
		Itemcategory category=new Itemcategory();
		category.setFcu(user.getDeptId()+"");
		List<Itemcategory> categoryList=this.categoryService.selectItemcategoryList(category);
		model.put("category", categoryList);
		Itemunit unit=new Itemunit();
		unit.setFcu(user.getDeptId()+"");
		model.put("unit", this.unitService.selectItemunitList(unit));
	    return prefix + "/add";
	}
	
	/**
	 * 新增保存商品
	 */
	@RequiresPermissions("module:item:add")
	@Log(title = "商品", businessType = BusinessType.INSERT)
	@PostMapping("/add")
	@ResponseBody
	public AjaxResult addSave(Item item)
	{		
		item.setFcu(ShiroUtils.getUser().getDeptId()+"");
		item.setFstatus(StatusEnum.NORMAL.getKey());
		return toAjax(itemService.insertItem(item));
	}

	/**
	 * 修改商品
	 */
	@GetMapping("/edit/{fid}")
	public String edit(@PathVariable("fid") Integer fid, ModelMap mmap)
	{
		Item item = itemService.selectItemById(fid);
		mmap.put("item", item);
		
		SysUser user=ShiroUtils.getUser();
		Itemcategory category=new Itemcategory();
		category.setFcu(user.getDeptId()+"");
		List<Itemcategory> categoryList=this.categoryService.selectItemcategoryList(category);
		mmap.put("category", categoryList);
		/** 商品分类的选择框是否选中***/
		if(StringUtils.isNotBlank(item.getFkcategoryid())){
			categoryList.forEach(obj->{
				if(obj.getFid().equals(item.getFkcategoryid())){
					obj.setFlag(true);
				}
			});
		}
		Itemunit unit=new Itemunit();
		unit.setFcu(user.getDeptId()+"");
		List<Itemunit> unitList=this.unitService.selectItemunitList(unit);
		mmap.put("unit", unitList);
		if(StringUtils.isNotBlank(item.getFkunitid())){
			/**商品单 位的下拉选择**/
			unitList.forEach(obj->{
				if(obj.getFid().equals(item.getFkunitid())){
					obj.setFlag(true);
				}
			});
		}
	    return prefix + "/edit";
	}
	
	/**
	 * 修改保存商品
	 */
	@RequiresPermissions("module:item:edit")
	@Log(title = "商品", businessType = BusinessType.UPDATE)
	@PostMapping("/edit")
	@ResponseBody
	public AjaxResult editSave(Item item)
	{		
		return toAjax(itemService.updateItem(item));
	}
	
	/**
	 * 删除商品
	 */
	@RequiresPermissions("module:item:remove")
	@Log(title = "商品", businessType = BusinessType.DELETE)
	@PostMapping( "/remove")
	@ResponseBody
	public AjaxResult remove(String ids)
	{		
		return toAjax(itemService.deleteItemByIds(ids));
	}
	
}
