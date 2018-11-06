package com.clothing.controller;

import java.util.Map;

import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.clothing.controller.base.BaseController;

@Controller
@RequestMapping(value="login")
public class LoginController extends BaseController{

	@RequestMapping(value="toLogin")
	public String login(){
		return "login";
	}
	
	@RequestMapping(value="submitLogin")
	public String submitLogin(HttpServletResponse response){
		String userName=this.getString("userName");
		String password=this.getString("pwssWord");
//		response.sendRedirect(arg0);
		return "redirect:/index";
	}
}

