package com.clothing.dao.item;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Mapper;

import com.clothing.model.item.ItemUnit;

@Mapper
public interface ItemUnitDao {
	/**
	 * 根据ID 查询单位对象
	 * @param id
	 * @return
	 */
	ItemUnit getItemUnitById(String id);	
	/**
	 * 更新单位对象
	 * @param itemUnit
	 * @return
	 */
	int updateItemUnit(ItemUnit itemUnit);
	
	/**
	 * 新增
	 * @param itemUnit
	 * @return
	 */
	int insertItemUnit(ItemUnit itemUnit);
	
	int getItemUnitByCount(Map<String,Object> params);
	
	List<ItemUnit> getItemUnitByList(Map<String,Object> params);
}
