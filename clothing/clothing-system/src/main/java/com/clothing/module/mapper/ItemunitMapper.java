package com.clothing.module.mapper;

import com.clothing.module.domain.Itemunit;
import java.util.List;	

/**
 * 商品单 位 数据层
 * 
 * @author yangmin
 * @date 2018-11-17
 */
public interface ItemunitMapper 
{
	/**
     * 查询商品单 位信息
     * 
     * @param fid 商品单 位ID
     * @return 商品单 位信息
     */
	public Itemunit selectItemunitById(Integer fid);
	
	/**
     * 查询商品单 位列表
     * 
     * @param itemunit 商品单 位信息
     * @return 商品单 位集合
     */
	public List<Itemunit> selectItemunitList(Itemunit itemunit);
	
	/**
     * 新增商品单 位
     * 
     * @param itemunit 商品单 位信息
     * @return 结果
     */
	public int insertItemunit(Itemunit itemunit);
	
	/**
     * 修改商品单 位
     * 
     * @param itemunit 商品单 位信息
     * @return 结果
     */
	public int updateItemunit(Itemunit itemunit);
	
	/**
     * 删除商品单 位
     * 
     * @param fid 商品单 位ID
     * @return 结果
     */
	public int deleteItemunitById(Integer fid);
	
	/**
     * 批量删除商品单 位
     * 
     * @param fids 需要删除的数据ID
     * @return 结果
     */
	public int deleteItemunitByIds(String[] fids);
	
}