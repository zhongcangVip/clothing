package com.clothing.module.service;

import com.clothing.module.domain.Itemcategory;
import java.util.List;

/**
 * 商品类别 服务层
 * 
 * @author yangmin
 * @date 2018-11-21
 */
public interface IItemcategoryService 
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
     * 删除商品类别信息
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
	public int deleteItemcategoryByIds(String ids);
	
}
