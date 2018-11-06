package com.clothing.model.item;

import java.util.Date;

import com.clothing.model.base.Entity;
import com.clothing.model.base.enums.StatusEnum;

/**
 * 商品单位
 * @author yangmin
 * @date  2018年9月15日
 */
public class ItemUnit extends Entity<Integer>{

	private String code;
	private String name;
	private String description;//备注
	private String status; //StatusEnum
	
	private String userId;
	private Date createTime;
	private String lastupdateUserId;
	private Date lastUpdateTime;
	public String getCode() {
		return code;
	}
	public void setCode(String code) {
		this.code = code;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public String getUserId() {
		return userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}
	public Date getCreateTime() {
		return createTime;
	}
	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}
	public String getLastupdateUserId() {
		return lastupdateUserId;
	}
	public void setLastupdateUserId(String lastupdateUserId) {
		this.lastupdateUserId = lastupdateUserId;
	}
	public Date getLastUpdateTime() {
		return lastUpdateTime;
	}
	public void setLastUpdateTime(Date lastUpdateTime) {
		this.lastUpdateTime = lastUpdateTime;
	}
	

}
