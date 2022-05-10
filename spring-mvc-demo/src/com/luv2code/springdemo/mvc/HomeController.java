package com.luv2code.springdemo.mvc;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class HomeController {
	
	@RequestMapping("/")
	public String showPage() {
		//Our spring config specifies that this will return
		//WEB-INF/view/main-menu.jsp
		return "main-menu";
	}
}
