package com.clothing.model.user;

import java.util.Date;

import com.clothing.model.base.Entity;

/**
 * 用户基础实体
 * @author yangmin
 * @date  2018年9月15日
 */
public class User extends Entity<Integer>{

	private String userName;
	
	private String password;
	
	private String name;
	
	private String sex;
	
	private String mobile;
	
	private String idCard;
	
	private String firstMobile;//第一联系人
	
	private Shop shop;//所属店铺
	
	private Date caeateTime;
	
	private Date lastLoginTime;
	

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public Shop getShop() {
		return shop;
	}

	public void setShop(Shop shop) {
		this.shop = shop;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getSex() {
		return sex;
	}

	public void setSex(String sex) {
		this.sex = sex;
	}

	public String getMobile() {
		return mobile;
	}

	public void setMobile(String mobile) {
		this.mobile = mobile;
	}

	public String getIdCard() {
		return idCard;
	}

	public void setIdCard(String idCard) {
		this.idCard = idCard;
	}

	public String getFirstMobile() {
		return firstMobile;
	}

	public void setFirstMobile(String firstMobile) {
		this.firstMobile = firstMobile;
	}

	public Date getCaeateTime() {
		return caeateTime;
	}

	public void setCaeateTime(Date caeateTime) {
		this.caeateTime = caeateTime;
	}

	public Date getLastLoginTime() {
		return lastLoginTime;
	}

	public void setLastLoginTime(Date lastLoginTime) {
		this.lastLoginTime = lastLoginTime;
	}
}
