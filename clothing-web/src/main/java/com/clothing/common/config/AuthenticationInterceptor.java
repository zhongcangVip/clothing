package com.clothing.common.config;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.HandlerInterceptor;
/**
 * 权限控制拦截器
 * @author yangmin
 * @Date:2018年10月29日
 */
public class AuthenticationInterceptor  implements HandlerInterceptor{

	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		// TODO Auto-generated method stub
		return HandlerInterceptor.super.preHandle(request, response, handler);
	}
}
