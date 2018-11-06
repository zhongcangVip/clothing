package com.clothing.controller.item;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
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
import com.clothing.model.base.enums.StatusEnum;
import com.clothing.model.item.ItemSupplier;
import com.clothing.service.ItemSupplierService;

/**
 * 商品供应商
 * @author yangmin
 * @Date:2018年9月29日
 */
@Controller
@RequestMapping(value="itemSupplier")
public class ItemSupplierController extends BaseController{

	@Autowired
	private ItemSupplierService supplierService;
	
	@RequestMapping(value="list")
	public String list(){

		return "item/itemSupplierList";
	}
	
	@RequestMapping(value="listData")
	@ResponseBody
	public Pagination<ItemSupplier> listData(){
		int page=this.getInt("page",0);
		int pageSize=this.getInt("pageSize", 15);
		String name=this.getString("name");
		String code=this.getString("code");
		String status=this.getString("status");
		Map<String,Object> params=new HashMap<String,Object>();
		if(StringUtils.isNotBlank(name)){
			params.put("name", name);
		}
		if(StringUtils.isNotBlank(code)){
			params.put("code", code);
		}
		if(StringUtils.isNotBlank(status)){
			params.put("status", status);
		}
		Pagination<ItemSupplier> pagination=this.supplierService.getItemSupplierByPagination(page, pageSize, params);
		return pagination;
	}
	
	/**
	 * 修改商品供应商
	 * @param model
	 * @return
	 */
	@GetMapping("toAddOrEdit")
	public String toAddOrEdit(ModelMap model){
		String id=this.getString("id");
		ItemSupplier supplier=null;
		if(StringUtils.isNotBlank(id)){
			supplier=this.supplierService.getItemSupplierById(id);
			model.put("supplier", supplier);
		}
		return "item/itemSupplierInfo";
	}
	/**
	 * 查看供应商详情
	 * @param model
	 * @return
	 */
	@GetMapping(value="toView")
	public String toView(ModelMap model){
		String id=this.getString("id");
		ItemSupplier supplier=this.supplierService.getItemSupplierById(id);
		model.put("supplier", supplier);
		model.put("openModel", "view");
		return "item/itemSupplierInfo";
	}
	/**
	 * 提交修改与新增信息
	 * @return
	 */
	@PostMapping(value="submit")
	@ResponseBody
	public Result submit(){
		String id=this.getString("id");
		String code=this.getString("code");
		String name=this.getString("name");
		String contacts=this.getString("contacts");
		String mobile=this.getString("mobile");
		String qq=this.getString("qq");
		String wx=this.getString("wx");
		String email=this.getString("email");
		String address=this.getString("address");
		ItemSupplier supplier=null;
		
		if(StringUtils.isNotBlank(id)){
			supplier=this.supplierService.getItemSupplierById(id);
		}else{
			supplier=new ItemSupplier();
			supplier.setCode(code);
			supplier.setStatus(StatusEnum.NORMAL.getKey());
			supplier.setCreateTime(new Date());
		}
		supplier.setName(name);
		supplier.setContacts(contacts);
		supplier.setMobile(mobile);
		supplier.setQq(qq);
		supplier.setWx(wx);
		supplier.setEmail(email);
		supplier.setAddress(address);
		supplier.setLastupdateTime(new Date());
		this.supplierService.updateItemSupplier(supplier);
		return ResultUtil.success();
	}
	/**
	 * 逻辑删除供应商信息
	 * @return
	 */
	@PostMapping(value="del")
	@ResponseBody
	public Result delete(){
		String id=this.getString("id");
		ItemSupplier supplier=this.supplierService.getItemSupplierById(id);
		supplier.setStatus(StatusEnum.DELETE.getKey());
		this.supplierService.updateItemSupplier(supplier);
		return ResultUtil.success();
	}
	@PostMapping(value="updateStatus")
	@ResponseBody
	public Result updateStatus(){
		String id=this.getString("id");
		ItemSupplier supplier=this.supplierService.getItemSupplierById(id);
		if(supplier.getStatus().equals(StatusEnum.NORMAL.getKey())){
			supplier.setStatus(StatusEnum.DELETE.getKey());
		}else{
			supplier.setStatus(StatusEnum.NORMAL.getKey());
		}
		this.supplierService.updateItemSupplier(supplier);
		return ResultUtil.success();
	}
	
}
