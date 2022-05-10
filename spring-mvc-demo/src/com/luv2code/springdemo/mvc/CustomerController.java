package com.luv2code.springdemo.mvc;

import javax.validation.Valid;

import org.springframework.beans.propertyeditors.StringTrimmerEditor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/customer")
public class CustomerController {
	//preprocesses all web requests coming into the controller
	@InitBinder
	public void initBinder(WebDataBinder dataBinder) {
		//trims the String or returns null if their is only spaces
		StringTrimmerEditor stringTrimmerEditor = new StringTrimmerEditor(true);
		
		dataBinder.registerCustomEditor(String.class, stringTrimmerEditor);
	}
	
	@RequestMapping("/showForm")
	public String showForm(Model model) {
		model.addAttribute("customer", new Customer());
		
		return "customer-form";
	}
	
	@RequestMapping("/processForm")
	public String processForm(@Valid @ModelAttribute("customer")
			Customer customer, BindingResult result) {
		
		System.out.println("Binding result: " + result);
		
		System.out.println("\n\n\n\n");
		
		System.out.println("Last Name: |" + customer.getLastName() + "|");
		if (result.hasErrors()) {
			return "customer-form";
		}
		
		return "customer-confirmation";
	}
	

}
