package com.clothing.service;

import java.util.List;
import java.util.Map;

import com.clothing.model.base.Pagination;
import com.clothing.model.item.Item;

public interface ItemService {
	
	public Item getItemById(String id);
	
	public List<Item> getItemByList(Map<String,Object> params);
	
	public Pagination<Item> getItemByPagination(int page,int pageSize,Map<String,Object> params);
	
	public int insertItem(Item item);
	
	public int updateIntem(Item item);
	
}
