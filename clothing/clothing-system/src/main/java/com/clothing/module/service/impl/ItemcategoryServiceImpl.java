package com.clothing.module.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.clothing.module.mapper.ItemcategoryMapper;
import com.clothing.module.domain.Itemcategory;
import com.clothing.module.service.IItemcategoryService;
import com.clothing.common.support.Convert;

/**
 * 商品类别 服务层实现
 * 
 * @author yangmin
 * @date 2018-11-21
 */
@Service
public class ItemcategoryServiceImpl implements IItemcategoryService 
{
	@Autowired
	private ItemcategoryMapper itemcategoryMapper;

	/**
     * 查询商品类别信息
     * 
     * @param fid 商品类别ID
     * @return 商品类别信息
     */
    @Override
	public Itemcategory selectItemcategoryById(Integer fid)
	{
	    return itemcategoryMapper.selectItemcategoryById(fid);
	}
	
	/**
     * 查询商品类别列表
     * 
     * @param itemcategory 商品类别信息
     * @return 商品类别集合
     */
	@Override
	public List<Itemcategory> selectItemcategoryList(Itemcategory itemcategory)
	{
	    return itemcategoryMapper.selectItemcategoryList(itemcategory);
	}
	
    /**
     * 新增商品类别
     * 
     * @param itemcategory 商品类别信息
     * @return 结果
     */
	@Override
	public int insertItemcategory(Itemcategory itemcategory)
	{
	    return itemcategoryMapper.insertItemcategory(itemcategory);
	}
	
	/**
     * 修改商品类别
     * 
     * @param itemcategory 商品类别信息
     * @return 结果
     */
	@Override
	public int updateItemcategory(Itemcategory itemcategory)
	{
	    return itemcategoryMapper.updateItemcategory(itemcategory);
	}

	/**
     * 删除商品类别对象
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
	@Override
	public int deleteItemcategoryByIds(String ids)
	{
		return itemcategoryMapper.deleteItemcategoryByIds(Convert.toStrArray(ids));
	}
	
}
