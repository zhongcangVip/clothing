package com.clothing.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestMapping;

import com.clothing.controller.base.BaseController;
import com.clothing.model.vo.ResultData;
import com.clothing.model.vo.user.LoginRequest;
import com.clothing.service.user.UserService;

@Controller
@RequestMapping(value="login")
public class LoginController extends BaseController{

	@Autowired
	private UserService userService;
	
	@RequestMapping(value="toLogin")
	public String login(ModelMap model){
		return "login";
	}
	
	@RequestMapping(value="submitLogin")
	public String submitLogin(@Validated LoginRequest loginInfo,ModelMap model){
		ResultData<String> result=this.userService.login(loginInfo);
		if(result.success()) {
			return "redirect:/index";
		}else {
			model.put("msg", result.getMsg());
			return login(model);
		}
	}
}

