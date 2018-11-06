//package com.clothing.common.config;
//
//import org.springframework.context.annotation.Configuration;
//import org.springframework.security.config.annotation.web.builders.HttpSecurity;
//import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
///**
// * spring security 配置类
// * @author yangmin
// * @date  2018年9月27日
// */
//@Configuration
//public class SecurityConfig extends WebSecurityConfigurerAdapter{
//
//	@Override
//	protected void configure(HttpSecurity http) throws Exception {
////		http.formLogin()                    //  定义当需要用户登录时候，转到的登录页面。
////        .loginPage("/login/toLogin")           // 设置登录页面
////        .loginProcessingUrl("/login/submitLogin")  // 自定义的登录接口
////        .and()
////        .authorizeRequests()        // 定义哪些URL需要被保护、哪些不需要被保护
////        .antMatchers("/login/toLogin").permitAll()     // 设置所有人都可以访问登录页面
////        .anyRequest()               // 任何请求,登录后可以访问
////        .authenticated()
////        .and()
////        .csrf().disable();          // 关闭csrf防护
//		super.configure(http);
//		
//	}
//}
