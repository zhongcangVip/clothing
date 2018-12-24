package com.clothing.module.service;

import com.clothing.module.domain.PurchaseDetail;
import com.clothing.module.vo.PurchaseDetailVo;

import java.util.List;

/**
 * 采购单据明细 服务层
 * 
 * @author yangmin
 * @date 2018-11-26
 */
public interface IPurchaseDetailService 
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
	
	public List<PurchaseDetailVo> selectPurchaseDetailVoList(PurchaseDetail purchaseDetail);
	
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
     * 删除采购单据明细信息
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
	public int deletePurchaseDetailByIds(String ids);
	
}
