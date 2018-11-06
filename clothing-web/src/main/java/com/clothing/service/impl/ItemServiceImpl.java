package com.clothing.service.impl;

import java.util.List;
import java.util.Map;

import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CachePut;
import org.springframework.stereotype.Service;

import com.clothing.dao.RedisDao;
import com.clothing.dao.item.ItemDao;
import com.clothing.model.base.Pagination;
import com.clothing.model.item.Item;
import com.clothing.model.item.ItemUnit;
import com.clothing.service.ItemService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;

@Service
public class ItemServiceImpl implements ItemService{

	@Autowired
	private ItemDao itemDao;
	@Autowired
	private RedisDao redisDao;
	
	
	@Override
	public Item getItemById(String id) {
		// TODO Auto-generated method stub
		return this.itemDao.getItemById(id);
	}

	@Override
	public List<Item> getItemByList(Map<String, Object> params) {
		// TODO Auto-generated method stub
		return this.itemDao.getItemByList(params);
	}

	@Override
	public Pagination<Item> getItemByPagination(int page, int pageSize, Map<String, Object> params) {
		// TODO Auto-generated method stub
		PageHelper.startPage(page, pageSize);
		List<Item> list=this.getItemByList(params);
		PageInfo<Item> pageInfo=new PageInfo<>(list);
		Pagination<Item> pagination=new Pagination<>();
		pagination.setRows(pageInfo.getList());
		pagination.setCurrentPage(pageInfo.getPageNum());
		pagination.setPageSize(pageInfo.getPageSize());
		pagination.setTotal(pageInfo.getTotal());
		pagination.setTotalPage(pageInfo.getPages());
		return pagination;
	}

	@Override
	public int insertItem(Item item) {
		// TODO Auto-generated method stub
		return this.itemDao.insertItem(item);
	}

	@Override
	public int updateIntem(Item item) {
		// TODO Auto-generated method stub
		return this.itemDao.updateItem(item);
	}

}
