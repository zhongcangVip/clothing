package com.clothing.service;

import java.util.List;
import java.util.Map;

import com.clothing.model.base.Pagination;
import com.clothing.model.item.ItemCategory;

public interface ItemCategoryService {

	public void insertItemCategory(ItemCategory info);
	
	public void updateItemCategory(ItemCategory info);
	
	public ItemCategory getItemCategoryById(String id);
	
	public List<ItemCategory> getItemCategoryByList(Map<String,Object> params);
	
	public Pagination<ItemCategory> getItemCategoryByPagination(int page,int pageSize,Map<String,Object> params);
}
