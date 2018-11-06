package com.clothing.dao.item;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Mapper;

import com.clothing.model.item.ItemCategory;

@Mapper
public interface ItemCategoryDao {

	public void insertItemCategory(ItemCategory info);

	public void updateItemCategory(ItemCategory info);

	public ItemCategory getItemCategoryById(String id);

	public List<ItemCategory> getItemCategoryByList(Map<String, Object> params);
}
