package com.clothing.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import com.clothing.controller.base.BaseController;

@Controller
public class IndexController extends BaseController{
	
	@GetMapping(value="index")
	public String index(){
		return "index";
	}
}
