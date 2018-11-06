package com.clothing.model.item;

import java.util.Date;

import com.clothing.model.base.Entity;
import com.clothing.model.item.enums.ItemOperatorModel;

/**
 * 商品相关操作记录
 * @author yangmin
 * @date  2018年9月15日
 */
public class ItemOperator extends Entity<Integer>{
	
	private ItemOperatorModel model;//操作模块
	
	private String userId; 
	
	private String value;//关键值,可能会当成查询条件之类
	
	private String description; //操作描述
	
	private String objectId;//操作对象ID
	
	private Date operatorTime; //操作时间

	public ItemOperatorModel getModel() {
		return model;
	}

	public void setModel(ItemOperatorModel model) {
		this.model = model;
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public String getValue() {
		return value;
	}

	public void setValue(String value) {
		this.value = value;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getObjectId() {
		return objectId;
	}

	public void setObjectId(String objectId) {
		this.objectId = objectId;
	}

	public Date getOperatorTime() {
		return operatorTime;
	}

	public void setOperatorTime(Date operatorTime) {
		this.operatorTime = operatorTime;
	}
}
