package com.clothing.service.impl;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.clothing.dao.item.ItemCategoryDao;
import com.clothing.model.base.Pagination;
import com.clothing.model.item.ItemCategory;
import com.clothing.model.item.ItemSupplier;
import com.clothing.service.ItemCategoryService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;

@Service
public class ItemCategoryServiceImpl implements ItemCategoryService{

	@Autowired
	private ItemCategoryDao categoryDao;
	@Override
	public void insertItemCategory(ItemCategory info) {
		// TODO Auto-generated method stub
		this.categoryDao.insertItemCategory(info);
	}

	@Override
	public void updateItemCategory(ItemCategory info) {
		// TODO Auto-generated method stub
		this.categoryDao.updateItemCategory(info);
	}

	@Override
	public ItemCategory getItemCategoryById(String id) {
		// TODO Auto-generated method stub
		return this.categoryDao.getItemCategoryById(id);
	}

	@Override
	public List<ItemCategory> getItemCategoryByList(Map<String, Object> params) {
		// TODO Auto-generated method stub
		return this.categoryDao.getItemCategoryByList(params);
	}

	@Override
	public Pagination<ItemCategory> getItemCategoryByPagination(int page, int pageSize, Map<String, Object> params) {
		// TODO Auto-generated method stub
		PageHelper.startPage(page, pageSize);
		List<ItemCategory> list=this.getItemCategoryByList(params);
		PageInfo<ItemCategory> pageInfo=new PageInfo<>(list);
		Pagination<ItemCategory> pagination=new Pagination<>();
		pagination.setRows(pageInfo.getList());
		pagination.setCurrentPage(pageInfo.getPageNum());
		pagination.setPageSize(pageInfo.getPageSize());
		pagination.setTotal(pageInfo.getTotal());
		pagination.setTotalPage(pageInfo.getPages());
		return pagination;
	}

}
