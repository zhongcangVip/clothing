package com.clothing.dao.item;

import org.apache.ibatis.annotations.Mapper;

import com.clothing.model.item.ItemOperator;

@Mapper
public interface ItemOperatorDao {

	public void insertItemOperator(ItemOperator record);
}
