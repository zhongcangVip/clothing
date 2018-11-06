package com.clothing.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.clothing.dao.item.ItemOperatorDao;
import com.clothing.model.item.ItemOperator;
import com.clothing.service.ItemOperatorService;

@Service
public class ItemOperatorServiceImpl implements ItemOperatorService{

	@Autowired
	private ItemOperatorDao operatorDao;
	
	@Override
	public void insertOperator(ItemOperator record) {
		// TODO Auto-generated method stub
		this.operatorDao.insertItemOperator(record);
	}

}
