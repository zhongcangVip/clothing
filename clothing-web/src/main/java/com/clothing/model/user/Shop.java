package com.clothing.model.user;

import java.util.Date;

import com.clothing.model.base.Entity;

/**
 * 店铺
 * @author yangmin
 * @date  2018年9月29日
 */
public class Shop extends Entity<Integer>{
	
	private String code;
	private String name;
	
	private String mobile;
	private String realName;//店铺联系人
	private Shop parentShop; //上级店铺
	
	private String province;
	private String city;
	private String area;
	private String address;
	
	private Date createTime;
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
	public String getMobile() {
		return mobile;
	}
	public void setMobile(String mobile) {
		this.mobile = mobile;
	}
	public String getRealName() {
		return realName;
	}
	public void setRealName(String realName) {
		this.realName = realName;
	}
	public Shop getParentShop() {
		return parentShop;
	}
	public void setParentShop(Shop parentShop) {
		this.parentShop = parentShop;
	}
	public String getProvince() {
		return province;
	}
	public void setProvince(String province) {
		this.province = province;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public String getArea() {
		return area;
	}
	public void setArea(String area) {
		this.area = area;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public Date getCreateTime() {
		return createTime;
	}
	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}
	public Date getLastUpdateTime() {
		return lastUpdateTime;
	}
	public void setLastUpdateTime(Date lastUpdateTime) {
		this.lastUpdateTime = lastUpdateTime;
	}
}
