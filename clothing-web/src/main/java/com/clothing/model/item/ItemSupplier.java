package com.clothing.model.item;

import java.util.Date;

import com.clothing.model.base.Entity;
import com.clothing.model.base.enums.StatusEnum;

/**
 * 商品供应商
 * @author yangmin
 * @date  2018年9月15日
 */
public class ItemSupplier extends Entity<Integer>{

	private String code;
	private String name;//供应商品牌名称
	private String address;//供应商地址
	private String contacts;//供应商联系人
	private String mobile;//供应商电话
	private String qq;
	private String wx;
	private String email;
	
	private String status; //StatusEnum;
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
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getContacts() {
		return contacts;
	}
	public void setContacts(String contacts) {
		this.contacts = contacts;
	}
	public String getMobile() {
		return mobile;
	}
	public void setMobile(String mobile) {
		this.mobile = mobile;
	}
	public String getQq() {
		return qq;
	}
	public void setQq(String qq) {
		this.qq = qq;
	}
	public String getWx() {
		return wx;
	}
	public void setWx(String wx) {
		this.wx = wx;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
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
	public Date getLastupdateTime() {
		return lastupdateTime;
	}
	public void setLastupdateTime(Date lastupdateTime) {
		this.lastupdateTime = lastupdateTime;
	}
}
