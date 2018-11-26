package com.clothing.module.mapper;

import com.clothing.module.domain.Purchase;
import java.util.List;	

/**
 * 采购单据 数据层
 * 
 * @author yangmin
 * @date 2018-11-26
 */
public interface PurchaseMapper 
{
	/**
     * 查询采购单据信息
     * 
     * @param purchaseId 采购单据ID
     * @return 采购单据信息
     */
	public Purchase selectPurchaseById(Integer purchaseId);
	
	/**
     * 查询采购单据列表
     * 
     * @param purchase 采购单据信息
     * @return 采购单据集合
     */
	public List<Purchase> selectPurchaseList(Purchase purchase);
	
	/**
     * 新增采购单据
     * 
     * @param purchase 采购单据信息
     * @return 结果
     */
	public int insertPurchase(Purchase purchase);
	
	/**
     * 修改采购单据
     * 
     * @param purchase 采购单据信息
     * @return 结果
     */
	public int updatePurchase(Purchase purchase);
	
	/**
     * 删除采购单据
     * 
     * @param purchaseId 采购单据ID
     * @return 结果
     */
	public int deletePurchaseById(Integer purchaseId);
	
	/**
     * 批量删除采购单据
     * 
     * @param purchaseIds 需要删除的数据ID
     * @return 结果
     */
	public int deletePurchaseByIds(String[] purchaseIds);
	
}