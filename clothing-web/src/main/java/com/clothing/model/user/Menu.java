package com.clothing.model.user;

import java.util.List;

import com.clothing.model.base.Entity;
/**
 * 菜单权限项
 * @author yangmin
 * @Date:2018年10月29日
 */
public class Menu extends Entity<Integer> {

	private String menuName; // 菜单名
	private String menuUrl; // 菜单路径
	private Integer parentId; // 上级菜单
	private String status; // 状态
	private Integer menuSeq; // 序列
	private Menu parentMenu;
	private String edit; //是否能修改此功能
	public String getMenuName() {
		return menuName;
	}
	public void setMenuName(String menuName) {
		this.menuName = menuName;
	}
	public String getMenuUrl() {
		return menuUrl;
	}
	public void setMenuUrl(String menuUrl) {
		this.menuUrl = menuUrl;
	}
	public Integer getParentId() {
		return parentId;
	}
	public void setParentId(Integer parentId) {
		this.parentId = parentId;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public Integer getMenuSeq() {
		return menuSeq;
	}
	public void setMenuSeq(Integer menuSeq) {
		this.menuSeq = menuSeq;
	}
	public Menu getParentMenu() {
		return parentMenu;
	}
	public void setParentMenu(Menu parentMenu) {
		this.parentMenu = parentMenu;
	}
	public String getEdit() {
		return edit;
	}
	public void setEdit(String edit) {
		this.edit = edit;
	}
	
}
