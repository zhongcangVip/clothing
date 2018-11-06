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
}
