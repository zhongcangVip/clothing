package com.clothing.service;

import java.util.List;
import java.util.Map;

import com.clothing.model.base.Pagination;
import com.clothing.model.item.ItemSupplier;

public interface ItemSupplierService {

	public void insertItemSupplier(ItemSupplier info);
	/**
	 * 如果itemSupplier.id==0或为空，则调用insert 新增一条记录
	 * @param info
	 */
	public void updateItemSupplier(ItemSupplier info);
	
	public ItemSupplier getItemSupplierById(String id);
	
	public List<ItemSupplier> getItemSupplierByList(Map<String,Object> params);
	
	public Pagination<ItemSupplier> getItemSupplierByPagination(int page,int pageSize,Map<String,Object> params);
}
