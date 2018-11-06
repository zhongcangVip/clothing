package com.clothing.dao.item;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Mapper;

import com.clothing.model.item.Item;

@Mapper
public interface ItemDao {
	
	public Item getItemById(String id);

	public List<Item> getItemByList(Map<String, Object> params);

	public int insertItem(Item item);

	public int updateItem(Item item);
}
