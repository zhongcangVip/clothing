package com.clothing.module.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.clothing.common.support.Convert;
import com.clothing.module.domain.Item;
import com.clothing.module.domain.Itemunit;
import com.clothing.module.domain.PurchaseDetail;
import com.clothing.module.mapper.ItemMapper;
import com.clothing.module.mapper.ItemunitMapper;
import com.clothing.module.mapper.PurchaseDetailMapper;
import com.clothing.module.service.IPurchaseDetailService;
import com.clothing.module.vo.PurchaseDetailVo;

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
	@Autowired
	private ItemMapper itemMapper;
	@Autowired
	private ItemunitMapper unitMapper;

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

	@Override
	public List<PurchaseDetailVo> selectPurchaseDetailVoList(PurchaseDetail purchaseDetail) {
		// TODO Auto-generated method stub
		List<PurchaseDetail> list= purchaseDetailMapper.selectPurchaseDetailList(purchaseDetail);
		List<PurchaseDetailVo> resultList=new ArrayList<PurchaseDetailVo>();
		list.forEach(obj->{
			PurchaseDetailVo vo=new PurchaseDetailVo();
			BeanUtils.copyProperties(obj, vo);
			Item item=this.itemMapper.selectItemById(obj.getDetailItemId());
			if(null!=item){
				vo.setItemName(item.getFname());
				vo.setBarCode(item.getFbarcode());
				vo.setSize(item.getFsize());
				if(StringUtils.isNotBlank(item.getFkunitid())){
					Itemunit unit=unitMapper.selectItemunitById(Integer.valueOf(item.getFkunitid()));
					vo.setUnit(unit.getFname());
				}
			}
			resultList.add(vo);
		});
		return resultList;
	}
	
}
