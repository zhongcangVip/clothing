package com.clothing.module.mapper;

import com.clothing.module.domain.PurchaseDetail;
import java.util.List;	

/**
 * 采购单据明细 数据层
 * 
 * @author yangmin
 * @date 2018-11-26
 */
public interface PurchaseDetailMapper 
{
	/**
     * 查询采购单据明细信息
     * 
     * @param detailId 采购单据明细ID
     * @return 采购单据明细信息
     */
	public PurchaseDetail selectPurchaseDetailById(Integer detailId);
	
	/**
     * 查询采购单据明细列表
     * 
     * @param purchaseDetail 采购单据明细信息
     * @return 采购单据明细集合
     */
	public List<PurchaseDetail> selectPurchaseDetailList(PurchaseDetail purchaseDetail);
	
	/**
     * 新增采购单据明细
     * 
     * @param purchaseDetail 采购单据明细信息
     * @return 结果
     */
	public int insertPurchaseDetail(PurchaseDetail purchaseDetail);
	
	/**
     * 修改采购单据明细
     * 
     * @param purchaseDetail 采购单据明细信息
     * @return 结果
     */
	public int updatePurchaseDetail(PurchaseDetail purchaseDetail);
	
	/**
     * 删除采购单据明细
     * 
     * @param detailId 采购单据明细ID
     * @return 结果
     */
	public int deletePurchaseDetailById(Integer detailId);
	
	/**
     * 批量删除采购单据明细
     * 
     * @param detailIds 需要删除的数据ID
     * @return 结果
     */
	public int deletePurchaseDetailByIds(String[] detailIds);
	
}