package com.clothing.module.service;

import com.clothing.module.domain.Itemsupplier;
import java.util.List;

/**
 * 商品供应商 服务层
 * 
 * @author yangmin
 * @date 2018-11-21
 */
public interface IItemsupplierService 
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
     * 删除商品供应商信息
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
	public int deleteItemsupplierByIds(String ids);
	
}
