package com.clothing.module.mapper;

import com.clothing.module.domain.Itemsupplier;
import java.util.List;	

/**
 * 商品供应商 数据层
 * 
 * @author yangmin
 * @date 2018-11-21
 */
public interface ItemsupplierMapper 
{
	/**
     * 查询商品供应商信息
     * 
     * @param fid 商品供应商ID
     * @return 商品供应商信息
     */
	public Itemsupplier selectItemsupplierById(Integer fid);
	
	/**
     * 查询商品供应商列表
     * 
     * @param itemsupplier 商品供应商信息
     * @return 商品供应商集合
     */
	public List<Itemsupplier> selectItemsupplierList(Itemsupplier itemsupplier);
	
	/**
     * 新增商品供应商
     * 
     * @param itemsupplier 商品供应商信息
     * @return 结果
     */
	public int insertItemsupplier(Itemsupplier itemsupplier);
	
	/**
     * 修改商品供应商
     * 
     * @param itemsupplier 商品供应商信息
     * @return 结果
     */
	public int updateItemsupplier(Itemsupplier itemsupplier);
	
	/**
     * 删除商品供应商
     * 
     * @param fid 商品供应商ID
     * @return 结果
     */
	public int deleteItemsupplierById(Integer fid);
	
	/**
     * 批量删除商品供应商
     * 
     * @param fids 需要删除的数据ID
     * @return 结果
     */
	public int deleteItemsupplierByIds(String[] fids);
	
}