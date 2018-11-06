package com.clothing.common;

import com.clothing.model.user.User;

/**
 * 用户相关常量
 * @author yangmin
 * @Date:2018年10月29日
 */
public class UserConstants {

	/**
	 * token
	 */
	public static final String TOKEN = "token";
	/**
	 * 图片验证码
	 */
	public static final String IMAGE_CODE = "imageCode";
	/**
	 * 密码错误次数
	 */
	public static final String PWD_FAIL_COUNT = "PWD_FAIL_COUNT";
	
	/**
	 * 当前登录用户
	 */
	public static final ThreadLocal<User> USERS = new ThreadLocal<>();
}
