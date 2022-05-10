package com.luv2code.springdemo.mvc;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/hello")
public class HelloWorldController {
	
	//Need a controller method to show the initial form
	@RequestMapping("/showForm")
	public String showForm() {
		return "helloworld-form";
	}
	
	@RequestMapping("/processForm")
	public String processForm() {
		return "helloworld";
	}
	
	@RequestMapping("/processFormVersionTwo")
	public String shout(HttpServletRequest request, Model model) {
		
		//read the request parameter from the HTML form
		String name = request.getParameter("studentName");
		
		//convert data to uppercase
		name = name.toUpperCase();
		
		//create the message
		String result = "Hey " + name + "!";
		
		//add the message to the model
		model.addAttribute("message", result);
		
		return "helloworld";
	}
	
	@RequestMapping("/processFormVersionThree")
	public String processFormVersionThree
	(@RequestParam("studentName") String name, Model model) {
		
		//convert data to uppercase
		name = name.toUpperCase();
		
		//create the message
		String result = "Hey there " + name + "!";
		
		//add the message to the model
		model.addAttribute("message", result);
		
		return "helloworld";
	}
}
