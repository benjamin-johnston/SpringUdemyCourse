package com.luv2code.springdemo.mvc;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/student")
public class StudentController {
	
	//Need a controller method to show the initial form
	@RequestMapping("/showForm")
	public String showForm(Model model) {
		//create a student object
		Student student = new Student();
		
		//add student object to the model
		model.addAttribute("student", student);
		
		return "student-form";
	}
	
	//Need a controller method to show the initial form
	@RequestMapping("/processForm")
	public String processForm(@ModelAttribute("student") Student student) {
		
		System.out.println(student);
		
		return "student-confirmation";
	}
	
}
