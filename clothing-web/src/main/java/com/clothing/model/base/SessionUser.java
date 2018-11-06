package com.clothing.model.base;

/**
 * 线程绑定当前的登录用户
 * @author yangmin
 * @date  2018年9月29日
 */
public class SessionUser {

	private static final ThreadLocal currentUser = new ThreadLocal();

	@SuppressWarnings("unchecked")
	public static <T> T get() {
		return (T) currentUser.get();
	}

	@SuppressWarnings("unchecked")
	public static <T> void set(T user) {
		currentUser.set(user);
	}

	public static void clear() {
		currentUser.remove();
	}
}
