package com.clothing.common.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
/**
 * web 拦截器配置中心
 * @author yangmin
 * @Date:2018年10月29日
 */
@Configuration
public class WebConfig implements WebMvcConfigurer{

	@Override
	public void addInterceptors(InterceptorRegistry registry) {
		registry.addInterceptor(this.authenticationInterceptor()).addPathPatterns("/**");
	}
	
	@Bean
	public AuthenticationInterceptor authenticationInterceptor(){
		return new AuthenticationInterceptor();
	}
}
