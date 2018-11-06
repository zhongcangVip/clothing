package com.clothing.service;

import java.util.List;
import java.util.Map;

import com.clothing.model.base.Pagination;
import com.clothing.model.item.ItemUnit;

public interface ItemUnitService {

	public ItemUnit getItemUnitById(String id);

	int updateItemUnit(ItemUnit itemUnit);
	/**
	 * 新增
	 * 
	 * @param itemUnit
	 * @return
	 */
	int insertItemUnit(ItemUnit itemUnit);

	List<ItemUnit> getItemUnitByList(Map<String, Object> params);
	
	Pagination<ItemUnit> getItemUnitByPagination(Map<String,Object> params,int currentPage,int pageSize);
}
