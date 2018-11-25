package com.clothing.module.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.clothing.module.mapper.ItemMapper;
import com.clothing.module.domain.Item;
import com.clothing.module.service.IItemService;
import com.clothing.common.support.Convert;

/**
 * 商品 服务层实现
 * 
 * @author yangmin
 * @date 2018-11-23
 */
@Service
public class ItemServiceImpl implements IItemService 
{
	@Autowired
	private ItemMapper itemMapper;

	/**
     * 查询商品信息
     * 
     * @param fid 商品ID
     * @return 商品信息
     */
    @Override
	public Item selectItemById(Integer fid)
	{
	    return itemMapper.selectItemById(fid);
	}
	
	/**
     * 查询商品列表
     * 
     * @param item 商品信息
     * @return 商品集合
     */
	@Override
	public List<Item> selectItemList(Item item)
	{
	    return itemMapper.selectItemList(item);
	}
	
    /**
     * 新增商品
     * 
     * @param item 商品信息
     * @return 结果
     */
	@Override
	public int insertItem(Item item)
	{
	    return itemMapper.insertItem(item);
	}
	
	/**
     * 修改商品
     * 
     * @param item 商品信息
     * @return 结果
     */
	@Override
	public int updateItem(Item item)
	{
	    return itemMapper.updateItem(item);
	}

	/**
     * 删除商品对象
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
	@Override
	public int deleteItemByIds(String ids)
	{
		return itemMapper.deleteItemByIds(Convert.toStrArray(ids));
	}
	
}
