package com.clothing.module.mapper;

import com.clothing.module.domain.Itemcategory;
import java.util.List;	

/**
 * 商品类别 数据层
 * 
 * @author yangmin
 * @date 2018-11-21
 */
public interface ItemcategoryMapper 
{
	/**
     * 查询商品类别信息
     * 
     * @param fid 商品类别ID
     * @return 商品类别信息
     */
	public Itemcategory selectItemcategoryById(Integer fid);
	
	/**
     * 查询商品类别列表
     * 
     * @param itemcategory 商品类别信息
     * @return 商品类别集合
     */
	public List<Itemcategory> selectItemcategoryList(Itemcategory itemcategory);
	
	/**
     * 新增商品类别
     * 
     * @param itemcategory 商品类别信息
     * @return 结果
     */
	public int insertItemcategory(Itemcategory itemcategory);
	
	/**
     * 修改商品类别
     * 
     * @param itemcategory 商品类别信息
     * @return 结果
     */
	public int updateItemcategory(Itemcategory itemcategory);
	
	/**
     * 删除商品类别
     * 
     * @param fid 商品类别ID
     * @return 结果
     */
	public int deleteItemcategoryById(Integer fid);
	
	/**
     * 批量删除商品类别
     * 
     * @param fids 需要删除的数据ID
     * @return 结果
     */
	public int deleteItemcategoryByIds(String[] fids);
	
}