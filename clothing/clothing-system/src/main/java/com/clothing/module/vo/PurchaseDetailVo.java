package com.clothing.module.vo;

import java.math.BigDecimal;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

import com.clothing.common.base.BaseEntity;

/**
 * 采购单据明细表
 * 
 * @author yangmin
 * @date 2018-12-01
 */
public class PurchaseDetailVo extends BaseEntity
{
	private static final long serialVersionUID = 1L;
	
	/**  */
	private Integer detailId;
	/** 明细序号 */
	private Integer detailNo;
	/** 采购商品ID */
	private Integer detailItemId;
	/**商品名称**/
	private String itemName;
	/****条码****/
	private String barCode;
	/****单位****/
	private String unit;
	/******尺寸*******/
	private String size;
	
	private Double detailNum;
	/** 采购商品数量 */
	private Double detailItemQuantity;
	/** 赠送数量 */
	private Double detailItemGiveQuantity;
	/** 采购价格 */
	private BigDecimal detailPrice;
	/** 采购描述 */
	private String detailDescription;
	/** 采购金额 */
	private BigDecimal detailAmount;
	/** 采购单号 */
	private Integer purchaseId;

	public void setDetailId(Integer detailId) 
	{
		this.detailId = detailId;
	}

	public Integer getDetailId() 
	{
		return detailId;
	}
	public void setDetailNo(Integer detailNo) 
	{
		this.detailNo = detailNo;
	}

	public Integer getDetailNo() 
	{
		return detailNo;
	}
	public void setDetailItemId(Integer detailItemId) 
	{
		this.detailItemId = detailItemId;
	}

	public Integer getDetailItemId() 
	{
		return detailItemId;
	}
	public void setDetailItemQuantity(Double detailItemQuantity) 
	{
		this.detailItemQuantity = detailItemQuantity;
	}

	public Double getDetailItemQuantity() 
	{
		return detailItemQuantity;
	}
	public void setDetailItemGiveQuantity(Double detailItemGiveQuantity) 
	{
		this.detailItemGiveQuantity = detailItemGiveQuantity;
	}

	public Double getDetailItemGiveQuantity() 
	{
		return detailItemGiveQuantity;
	}
	public void setDetailPrice(BigDecimal detailPrice) 
	{
		this.detailPrice = detailPrice;
	}

	public BigDecimal getDetailPrice() 
	{
		return detailPrice;
	}
	public void setDetailDescription(String detailDescription) 
	{
		this.detailDescription = detailDescription;
	}

	public String getDetailDescription() 
	{
		return detailDescription;
	}
	public void setDetailAmount(BigDecimal detailAmount) 
	{
		this.detailAmount = detailAmount;
	}

	public BigDecimal getDetailAmount() 
	{
		return detailAmount;
	}
	public void setPurchaseId(Integer purchaseId) 
	{
		this.purchaseId = purchaseId;
	}

	public Integer getPurchaseId() 
	{
		return purchaseId;
	}
    public String getItemName() {
		return itemName;
	}

	public void setItemName(String itemName) {
		this.itemName = itemName;
	}

	public String getBarCode() {
		return barCode;
	}

	public void setBarCode(String barCode) {
		this.barCode = barCode;
	}

	public String getUnit() {
		return unit;
	}

	public void setUnit(String unit) {
		this.unit = unit;
	}

	public String getSize() {
		return size;
	}

	public void setSize(String size) {
		this.size = size;
	}

	
	public Double getDetailNum() {
		return detailNum;
	}

	public void setDetailNum(Double detailNum) {
		this.detailNum = detailNum;
	}

	public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("detailId", getDetailId())
            .append("detailNo", getDetailNo())
            .append("detailItemId", getDetailItemId())
            .append("detailItemQuantity", getDetailItemQuantity())
            .append("detailItemGiveQuantity", getDetailItemGiveQuantity())
            .append("detailPrice", getDetailPrice())
            .append("detailDescription", getDetailDescription())
            .append("detailAmount", getDetailAmount())
            .append("purchaseId", getPurchaseId())
            .toString();
    }
}
