package com.clothing.web.controller.item;

import java.util.List;
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
import com.clothing.common.enums.BusinessType;
import com.clothing.module.domain.Itemcategory;
import com.clothing.module.enums.StatusEnum;
import com.clothing.module.service.IItemcategoryService;
import com.clothing.framework.util.ShiroUtils;
import com.clothing.framework.web.base.BaseController;
import com.clothing.framework.web.page.TableDataInfo;
import com.clothing.common.base.AjaxResult;

/**
 * 商品类别 信息操作处理
 * 
 * @author yangmin
 * @date 2018-11-21
 */
@Controller
@RequestMapping("/module/itemcategory")
public class ItemcategoryController extends BaseController
{
    private String prefix = "module/itemcategory";
	
	@Autowired
	private IItemcategoryService itemcategoryService;
	
	@RequiresPermissions("module:itemcategory:view")
	@GetMapping()
	public String itemcategory()
	{
	    return prefix + "/itemcategory";
	}
	
	/**
	 * 查询商品类别列表
	 */
	@RequiresPermissions("module:itemcategory:list")
	@PostMapping("/list")
	@ResponseBody
	public TableDataInfo list(Itemcategory itemcategory)
	{
		if(!ShiroUtils.getUser().isAdmin()){
			itemcategory.setFcu(ShiroUtils.getUser().getDeptId()+"");
		}
		startPage();
        List<Itemcategory> list = itemcategoryService.selectItemcategoryList(itemcategory);
        list.forEach(obj->{
        	StatusEnum status=StatusEnum.valueOf(obj.getFstatus());
        	if(status!=null){
        		obj.setFstatus(status.getDescription());
        	}
        });
		return getDataTable(list);
	}
	
	/**
	 * 新增商品类别
	 */
	@GetMapping("/add")
	public String add()
	{
	    return prefix + "/add";
	}
	
	/**
	 * 新增保存商品类别
	 */
	@RequiresPermissions("module:itemcategory:add")
	@Log(title = "商品类别", businessType = BusinessType.INSERT)
	@PostMapping("/add")
	@ResponseBody
	public AjaxResult addSave(Itemcategory itemcategory)
	{		
		itemcategory.setFcu(ShiroUtils.getUser().getDeptId()+"");
		itemcategory.setFstatus(StatusEnum.NORMAL.getKey());
		return toAjax(itemcategoryService.insertItemcategory(itemcategory));
	}

	/**
	 * 修改商品类别
	 */
	@GetMapping("/edit/{fid}")
	public String edit(@PathVariable("fid") Integer fid, ModelMap mmap)
	{
		Itemcategory itemcategory = itemcategoryService.selectItemcategoryById(fid);
		mmap.put("itemcategory", itemcategory);
	    return prefix + "/edit";
	}
	
	/**
	 * 修改保存商品类别
	 */
	@RequiresPermissions("module:itemcategory:edit")
	@Log(title = "商品类别", businessType = BusinessType.UPDATE)
	@PostMapping("/edit")
	@ResponseBody
	public AjaxResult editSave(Itemcategory itemcategory)
	{		
		return toAjax(itemcategoryService.updateItemcategory(itemcategory));
	}
	
	/**
	 * 删除商品类别
	 */
	@RequiresPermissions("module:itemcategory:remove")
	@Log(title = "商品类别", businessType = BusinessType.DELETE)
	@PostMapping( "/remove")
	@ResponseBody
	public AjaxResult remove(String ids)
	{		
		return toAjax(itemcategoryService.deleteItemcategoryByIds(ids));
	}
	
}
