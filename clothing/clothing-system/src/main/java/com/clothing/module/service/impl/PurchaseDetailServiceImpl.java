package com.clothing.module.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.clothing.module.mapper.PurchaseDetailMapper;
import com.clothing.module.domain.PurchaseDetail;
import com.clothing.module.service.IPurchaseDetailService;
import com.clothing.common.support.Convert;

/**
 * 采购单据明细 服务层实现
 * 
 * @author yangmin
 * @date 2018-11-26
 */
@Service
public class PurchaseDetailServiceImpl implements IPurchaseDetailService 
{
	@Autowired
	private PurchaseDetailMapper purchaseDetailMapper;

	/**
     * 查询采购单据明细信息
     * 
     * @param detailId 采购单据明细ID
     * @return 采购单据明细信息
     */
    @Override
	public PurchaseDetail selectPurchaseDetailById(Integer detailId)
	{
	    return purchaseDetailMapper.selectPurchaseDetailById(detailId);
	}
	
	/**
     * 查询采购单据明细列表
     * 
     * @param purchaseDetail 采购单据明细信息
     * @return 采购单据明细集合
     */
	@Override
	public List<PurchaseDetail> selectPurchaseDetailList(PurchaseDetail purchaseDetail)
	{
	    return purchaseDetailMapper.selectPurchaseDetailList(purchaseDetail);
	}
	
    /**
     * 新增采购单据明细
     * 
     * @param purchaseDetail 采购单据明细信息
     * @return 结果
     */
	@Override
	public int insertPurchaseDetail(PurchaseDetail purchaseDetail)
	{
	    return purchaseDetailMapper.insertPurchaseDetail(purchaseDetail);
	}
	
	/**
     * 修改采购单据明细
     * 
     * @param purchaseDetail 采购单据明细信息
     * @return 结果
     */
	@Override
	public int updatePurchaseDetail(PurchaseDetail purchaseDetail)
	{
	    return purchaseDetailMapper.updatePurchaseDetail(purchaseDetail);
	}

	/**
     * 删除采购单据明细对象
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
	@Override
	public int deletePurchaseDetailByIds(String ids)
	{
		return purchaseDetailMapper.deletePurchaseDetailByIds(Convert.toStrArray(ids));
	}
	
}
