package com.clothing.model.item;

import com.clothing.model.base.Entity;
import com.clothing.model.base.enums.StatusEnum;

/**
 * 商品SKU信息,一个商品多个SKU
 * SKU 信息暂时合并到商品中。
 * @author yangmin
 * @date  2018年9月15日
 */
@Deprecated
public class ItemSku extends Entity<Integer>{

	private Item item;
	private String size;//尺寸
	private String color;//颜色
	private String barCode;//条码，每个单独的SKU有可能会有单独的条码。
	private StatusEnum status;
	
	public Item getItem() {
		return item;
	}
	public void setItem(Item item) {
		this.item = item;
	}
	public String getSize() {
		return size;
	}
	public void setSize(String size) {
		this.size = size;
	}
	public String getColor() {
		return color;
	}
	public void setColor(String color) {
		this.color = color;
	}
	public String getBarCode() {
		return barCode;
	}
	public void setBarCode(String barCode) {
		this.barCode = barCode;
	}
	public StatusEnum getStatus() {
		return status;
	}
	public void setStatus(StatusEnum status) {
		this.status = status;
	}
}
