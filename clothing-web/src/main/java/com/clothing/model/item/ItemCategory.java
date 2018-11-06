package com.clothing.model.item;

import java.util.Date;

import com.clothing.model.base.Entity;
import com.clothing.model.base.enums.StatusEnum;

/**
 * 商品类别
 * @author yangmin
 * @date  2018年9月15日
 */
public class ItemCategory extends Entity<Integer>{
	/**
	 * 编码
	 */
	private String code;
	
	/**
	 * 名称
	 */
	private String name;
	/**
	 * 状态
	 */
	private StatusEnum status;
	/**
	 * 父类别
	 */
	private ItemCategory parent;
	/**
	 * 创建用户
	 */
	private String userId;
	private Date createTime;
	private String lastupdateUserId;
	private Date lastupdateTime;
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
	public StatusEnum getStatus() {
		return status;
	}
	public void setStatus(StatusEnum status) {
		this.status = status;
	}
	public ItemCategory getParent() {
		return parent;
	}
	public void setParent(ItemCategory parent) {
		this.parent = parent;
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
	public Date getLastupdateTime() {
		return lastupdateTime;
	}
	public void setLastupdateTime(Date lastupdateTime) {
		this.lastupdateTime = lastupdateTime;
	}
}
