package com.clothing.model.vo.user;

import com.clothing.model.user.Shop;

/**
   *   用户Vo,这个需要根据token放入到redis中
   *   所以此类尽量不要用大对象，只放需要用到的数据
 * 
 * @author Administrator
 *
 */
public class UserVo {

	private String id;
	private String userName;
	private String password;
	private String name;
	private String sex;
	private String mobile;
	private String idCard;
	private String firstMobile;// 第一联系人
	private String shopName;// 所属店铺	
	private String shopId;
	private String roleId;
	private String roleName;
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
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
	public String getShopName() {
		return shopName;
	}
	public void setShopName(String shopName) {
		this.shopName = shopName;
	}
	public String getShopId() {
		return shopId;
	}
	public void setShopId(String shopId) {
		this.shopId = shopId;
	}
	public String getRoleId() {
		return roleId;
	}
	public void setRoleId(String roleId) {
		this.roleId = roleId;
	}
	public String getRoleName() {
		return roleName;
	}
	public void setRoleName(String roleName) {
		this.roleName = roleName;
	}
	
}
