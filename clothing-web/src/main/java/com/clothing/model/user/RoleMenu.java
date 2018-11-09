package com.clothing.model.user;

import com.clothing.model.base.Entity;

/**
 	* 用户权限菜单关联
 * @author Administrator
 *
 */
public class RoleMenu extends Entity<Integer> {

	private Role role;
	private Menu menu;
	public Role getRole() {
		return role;
	}
	public void setRole(Role role) {
		this.role = role;
	}
	public Menu getMenu() {
		return menu;
	}
	public void setMenu(Menu menu) {
		this.menu = menu;
	}
	
}
