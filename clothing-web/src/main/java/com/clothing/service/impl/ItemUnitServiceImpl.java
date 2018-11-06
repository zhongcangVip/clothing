package com.clothing.service.impl;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.clothing.dao.item.ItemUnitDao;
import com.clothing.model.base.Pagination;
import com.clothing.model.item.ItemUnit;
import com.clothing.service.ItemUnitService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;

@Service
public class ItemUnitServiceImpl implements ItemUnitService{

	@Autowired
	private ItemUnitDao itemUnitDao;
	
	@Override
	public ItemUnit getItemUnitById(String id) {
		// TODO Auto-generated method stub
		return this.itemUnitDao.getItemUnitById(id);
	}

	@Override
	public int updateItemUnit(ItemUnit itemUnit) {
		// TODO Auto-generated method stub
		return this.itemUnitDao.updateItemUnit(itemUnit);
	}

	@Override
	public int insertItemUnit(ItemUnit itemUnit) {
		// TODO Auto-generated method stub
		return this.itemUnitDao.insertItemUnit(itemUnit);
	}

	@Override
	public List<ItemUnit> getItemUnitByList(Map<String, Object> params) {
		// TODO Auto-generated method stub
		return this.itemUnitDao.getItemUnitByList(params);
	}

	@Override
	public Pagination<ItemUnit> getItemUnitByPagination(Map<String, Object> params, int currentPage, int pageSize) {
		PageHelper.startPage(currentPage, pageSize);
		List<ItemUnit> list=this.itemUnitDao.getItemUnitByList(params);
		PageInfo<ItemUnit> pageInfo=new PageInfo<>(list);
		Pagination<ItemUnit> pagination=new Pagination<>();
		pagination.setRows(pageInfo.getList());
		pagination.setCurrentPage(pageInfo.getPageNum());
		pagination.setPageSize(pageInfo.getPageSize());
		pagination.setTotal(pageInfo.getTotal());
		pagination.setTotalPage(pageInfo.getPages());
		return pagination;
	}

}
