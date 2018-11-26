package com.clothing.module.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.clothing.module.mapper.PurchaseMapper;
import com.clothing.module.domain.Purchase;
import com.clothing.module.service.IPurchaseService;
import com.clothing.common.support.Convert;

/**
 * 采购单据 服务层实现
 * 
 * @author yangmin
 * @date 2018-11-26
 */
@Service
public class PurchaseServiceImpl implements IPurchaseService 
{
	@Autowired
	private PurchaseMapper purchaseMapper;

	/**
     * 查询采购单据信息
     * 
     * @param purchaseId 采购单据ID
     * @return 采购单据信息
     */
    @Override
	public Purchase selectPurchaseById(Integer purchaseId)
	{
	    return purchaseMapper.selectPurchaseById(purchaseId);
	}
	
	/**
     * 查询采购单据列表
     * 
     * @param purchase 采购单据信息
     * @return 采购单据集合
     */
	@Override
	public List<Purchase> selectPurchaseList(Purchase purchase)
	{
	    return purchaseMapper.selectPurchaseList(purchase);
	}
	
    /**
     * 新增采购单据
     * 
     * @param purchase 采购单据信息
     * @return 结果
     */
	@Override
	public int insertPurchase(Purchase purchase)
	{
	    return purchaseMapper.insertPurchase(purchase);
	}
	
	/**
     * 修改采购单据
     * 
     * @param purchase 采购单据信息
     * @return 结果
     */
	@Override
	public int updatePurchase(Purchase purchase)
	{
	    return purchaseMapper.updatePurchase(purchase);
	}

	/**
     * 删除采购单据对象
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
	@Override
	public int deletePurchaseByIds(String ids)
	{
		return purchaseMapper.deletePurchaseByIds(Convert.toStrArray(ids));
	}
	
}
