package com.clothing.model.user;

import com.clothing.model.base.Entity;
import com.clothing.model.base.enums.StatusEnum;

/**
 * 角色
 * @author yangmin
 * @Date:2018年10月29日
 */
public class Role extends Entity<Integer>{
	/**
	 * 角色名称
	 */
	private String name;
	/**
	 * 描述
	 */
	private String description;
	/**
	 * 状态
	 */
	private StatusEnum status;
	/**
	 * 额外的权限项
	 */
	private String otherMenus;
	
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
	public StatusEnum getStatus() {
		return status;
	}
	public void setStatus(StatusEnum status) {
		this.status = status;
	}
	public String getOtherMenus() {
		return otherMenus;
	}
	public void setOtherMenus(String otherMenus) {
		this.otherMenus = otherMenus;
	}
}
