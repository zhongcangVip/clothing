package com.clothing.web.controller.order;

import java.util.Date;
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
import com.clothing.module.domain.Itemsupplier;
import com.clothing.module.domain.Purchase;
import com.clothing.module.service.IItemsupplierService;
import com.clothing.module.service.IItemunitService;
import com.clothing.module.service.IPurchaseDetailService;
import com.clothing.module.service.IPurchaseService;
import com.clothing.system.domain.SysUser;

/**
 * 采购单据 信息操作处理
 * 
 * @author yangmin
 * @date 2018-11-26
 */
@Controller
@RequestMapping("/module/purchase")
public class PurchaseController extends BaseController
{
    private String prefix = "module/purchase";
	
	@Autowired
	private IPurchaseService purchaseService;
	@Autowired
	private IPurchaseDetailService  purchaseDetailService;
	@Autowired
	private IItemunitService unitService;
	@Autowired
	private IItemsupplierService supplierService;
	
	@RequiresPermissions("module:purchase:view")
	@GetMapping()
	public String purchase()
	{
	    return prefix + "/purchase";
	}
	
	/**
	 * 查询采购单据列表
	 */
	@RequiresPermissions("module:purchase:list")
	@PostMapping("/list")
	@ResponseBody
	public TableDataInfo list(Purchase purchase)
	{
		SysUser user=ShiroUtils.getUser();
		if(!user.isAdmin()){
			purchase.setDeptId(user.getDeptId()+"");
		}
		startPage();
        List<Purchase> list = purchaseService.selectPurchaseList(purchase);
        list.forEach(obj->{
        	//重构或是二次查询数据
        	if(StringUtils.isNotBlank(obj.getPurchaseSupplierId())){
        		Itemsupplier supplier=this.supplierService.selectItemsupplierById(Integer.valueOf(obj.getPurchaseSupplierId()));
        		obj.setPurchaseSupplierId(supplier.getFname());
        	}
        });
		return getDataTable(list);
	}
	
	/**
	 * 新增采购单据
	 */
	@GetMapping("/add")
	public String add()
	{
	    return prefix + "/add";
	}
	
	/**
	 * 新增保存采购单据
	 */
	@RequiresPermissions("module:purchase:add")
	@Log(title = "采购单据", businessType = BusinessType.INSERT)
	@PostMapping("/add")
	@ResponseBody
	public AjaxResult addSave(Purchase purchase)
	{		
		SysUser user=ShiroUtils.getUser();
		purchase.setCreateby(user.getUserId().intValue());
		purchase.setCreatetime(new Date());
		purchase.setLastupdateby(user.getUserId().intValue());
		purchase.setLastupdatetime(new Date());
		return toAjax(purchaseService.insertPurchase(purchase));
	}

	/**
	 * 修改采购单据
	 */
	@GetMapping("/edit/{purchaseId}")
	public String edit(@PathVariable("purchaseId") Integer purchaseId, ModelMap mmap)
	{
		Purchase purchase = purchaseService.selectPurchaseById(purchaseId);
		mmap.put("purchase", purchase);
	    return prefix + "/edit";
	}
	
	/**
	 * 修改保存采购单据
	 */
	@RequiresPermissions("module:purchase:edit")
	@Log(title = "采购单据", businessType = BusinessType.UPDATE)
	@PostMapping("/edit")
	@ResponseBody
	public AjaxResult editSave(Purchase purchase)
	{		
		return toAjax(purchaseService.updatePurchase(purchase));
	}
	
	/**
	 * 删除采购单据
	 */
	@RequiresPermissions("module:purchase:remove")
	@Log(title = "采购单据", businessType = BusinessType.DELETE)
	@PostMapping( "/remove")
	@ResponseBody
	public AjaxResult remove(String ids)
	{		
		return toAjax(purchaseService.deletePurchaseByIds(ids));
	}
	
}
