package com.clothing.web.controller.order;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.lang3.StringUtils;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.clothing.common.OrderNoConstants;
import com.clothing.common.annotation.Log;
import com.clothing.common.base.AjaxResult;
import com.clothing.common.enums.BusinessType;
import com.clothing.framework.util.ShiroUtils;
import com.clothing.framework.web.base.BaseController;
import com.clothing.framework.web.page.TableDataInfo;
import com.clothing.module.domain.Itemsupplier;
import com.clothing.module.domain.Purchase;
import com.clothing.module.domain.PurchaseDetail;
import com.clothing.module.enums.StatusEnum;
import com.clothing.module.service.IItemsupplierService;
import com.clothing.module.service.IItemunitService;
import com.clothing.module.service.IPurchaseDetailService;
import com.clothing.module.service.IPurchaseService;
import com.clothing.module.vo.PurchaseDetailVo;
import com.clothing.system.domain.SysUser;


/**
 * 采购单据 信息操作处理
 * 
 * @author yangmin
 * @date 2018-11-26
 */
@Controller
@RequestMapping("/module/purchase")
public class PurchaseController extends BaseController{
	
	private static final Logger logger=LoggerFactory.getLogger(PurchaseController.class);
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
	public TableDataInfo list(Purchase purchase,HttpServletRequest request)
	{
		String searchValue=request.getParameter("searchValue");
		purchase.setSearchValue(searchValue);
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
	public AjaxResult addSave(Purchase purchase,HttpServletRequest request)
	{		
		SysUser user=ShiroUtils.getUser();
		
		buildPurchaseDetailInfo(purchase, request);
		purchase.setCreateby(user.getUserId().intValue());
		purchase.setCreatetime(new Date());
		purchase.setLastupdateby(user.getUserId().intValue());
		purchase.setLastupdatetime(new Date());
		purchase.setPurchaseStatus(StatusEnum.NORMAL.getKey());
		String orderNo=super.getOrderNo(OrderNoConstants.PURCHASE_PREFIX);
		logger.info(orderNo);
		purchase.setPurchaseOrderno(orderNo);
		return toAjax(purchaseService.insertPurchase(purchase));
	}
	/**
	 * 构建代购单的明细信息
	 * @param purchase
	 * @param request
	 */
	private void buildPurchaseDetailInfo(Purchase purchase, HttpServletRequest request) {
		String[] itemId=request.getParameterValues("item_id");
		String[] num=request.getParameterValues("num");//件数
		String[] quantity=request.getParameterValues("quantity");//数量
		String[] giveQuantity=request.getParameterValues("giveQuantity");//赠送数据
		String[] price=request.getParameterValues("price");
		String[] description=request.getParameterValues("description");
		String[] amount=request.getParameterValues("amount");
		String[] detailNo=request.getParameterValues("detailNo");
		List<PurchaseDetail> list=new ArrayList<PurchaseDetail>();
		for(int i=0;itemId!=null && i<itemId.length;i++){
			PurchaseDetail detail=new PurchaseDetail();
			detail.setDetailItemId(Integer.valueOf(itemId[i]));
			if(description.length>i && StringUtils.isNoneBlank(description[i])){
				detail.setDetailDescription(description[i]);
			}
			if(amount !=null && amount.length>i && StringUtils.isNoneBlank(amount[i])){
				detail.setDetailAmount(new BigDecimal(amount[i]));
			}
			detail.setDetailItemGiveQuantity(Double.valueOf(giveQuantity[i]));
			detail.setDetailItemQuantity(Double.valueOf(quantity[i]));
			detail.setDetailPrice(new BigDecimal(price[i]));
			if(detailNo !=null && detailNo.length>i && StringUtils.isNoneBlank(detailNo[i])){
				detail.setDetailNo(Integer.valueOf(detailNo[i]));
			}
			list.add(detail);
		}
		purchase.setList(list);
	}

	/**
	 * 修改采购单据
	 */
	@GetMapping("/edit/{purchaseId}")
	public String edit(@PathVariable("purchaseId") Integer purchaseId, ModelMap mmap)
	{
		Purchase purchase = purchaseService.selectPurchaseById(purchaseId);
		PurchaseDetail purchaseDetail=new PurchaseDetail();
		purchaseDetail.setPurchaseId(purchaseId);
		List<PurchaseDetailVo> list=purchaseDetailService.selectPurchaseDetailVoList(purchaseDetail);
		Itemsupplier supplier=this.supplierService.selectItemsupplierById(Integer.valueOf(purchase.getPurchaseSupplierId()));
		purchase.setPurchaseSupplierName(supplier.getFname());
		mmap.put("purchase", purchase);
		mmap.put("list", list);
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
