package com.clothing.module.mapper;

import com.clothing.module.domain.Item;
import java.util.List;	

/**
 * 商品 数据层
 * 
 * @author yangmin
 * @date 2018-11-23
 */
public interface ItemMapper 
{
	/**
     * 查询商品信息
     * 
     * @param fid 商品ID
     * @return 商品信息
     */
	public Item selectItemById(Integer fid);
	
	/**
     * 查询商品列表
     * 
     * @param item 商品信息
     * @return 商品集合
     */
	public List<Item> selectItemList(Item item);
	
	/**
     * 新增商品
     * 
     * @param item 商品信息
     * @return 结果
     */
	public int insertItem(Item item);
	
	/**
     * 修改商品
     * 
     * @param item 商品信息
     * @return 结果
     */
	public int updateItem(Item item);
	
	/**
     * 删除商品
     * 
     * @param fid 商品ID
     * @return 结果
     */
	public int deleteItemById(Integer fid);
	
	/**
     * 批量删除商品
     * 
     * @param fids 需要删除的数据ID
     * @return 结果
     */
	public int deleteItemByIds(String[] fids);
	
}