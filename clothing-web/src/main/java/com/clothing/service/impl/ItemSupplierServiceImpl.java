package com.clothing.service.impl;

import java.util.List;
import java.util.Map;

import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.clothing.dao.item.ItemSupplierDao;
import com.clothing.model.base.Pagination;
import com.clothing.model.item.ItemSupplier;
import com.clothing.service.ItemSupplierService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;


@Service
public class ItemSupplierServiceImpl implements ItemSupplierService{

	@Autowired
	private ItemSupplierDao supplierDao;
	
	@Override
	public void insertItemSupplier(ItemSupplier info) {
		// TODO Auto-generated method stub
		this.supplierDao.insertItemSupplier(info);
	}

	@Override
	public void updateItemSupplier(ItemSupplier info) {
		// TODO Auto-generated method stub
		if(null==info.getId()|| info.getId()==0){
			this.insertItemSupplier(info);
		}else{
			this.supplierDao.updateItemSupplier(info);
		}
	}

	@Override
	public ItemSupplier getItemSupplierById(String id) {
		// TODO Auto-generated method stub
		return this.supplierDao.getItemSupplierById(id);
	}

	@Override
	public List<ItemSupplier> getItemSupplierByList(Map<String, Object> params) {
		// TODO Auto-generated method stub
		return this.supplierDao.getItemSupplierByList(params);
	}

	@Override
	public Pagination<ItemSupplier> getItemSupplierByPagination(int page, int pageSize, Map<String, Object> params) {
		// TODO Auto-generated method stub
		PageHelper.startPage(page, pageSize);
		List<ItemSupplier> list=this.getItemSupplierByList(params);
		PageInfo<ItemSupplier> pageInfo=new PageInfo<>(list);
		Pagination<ItemSupplier> pagination=new Pagination<>();
		pagination.setRows(pageInfo.getList());
		pagination.setCurrentPage(pageInfo.getPageNum());
		pagination.setPageSize(pageInfo.getPageSize());
		pagination.setTotal(pageInfo.getTotal());
		pagination.setTotalPage(pageInfo.getPages());
		return pagination;
	}

}
