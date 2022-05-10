package com.luv2code.springdemo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.luv2code.springdemo.entity.Customer;
import com.luv2code.springdemo.service.CustomerService;
import com.luv2code.springdemo.util.SortUtils;

@Controller
@RequestMapping("/customer")
public class CustomerController {
	
	//need to inject DAO
	@Autowired
	private CustomerService customerService;
	
	@GetMapping("/list")
	public String listCustomers(Model model, @RequestParam(required=false) String sort) {
		// get customers from dao
		List<Customer> customers = null;
		
		if (sort != null) {
			int sortField = Integer.parseInt(sort);
			customers = customerService.getCustomers(sortField);
		} else {
			customers = customerService.getCustomers(SortUtils.LAST_NAME);
		}
		
		//add the customers to the model
		model.addAttribute("customers", customers);
		
		return "list-customers";
	}
	
	@GetMapping("/showFormForAdd")
	public String showFormForAdd(Model model) {
		//create model attribute to bind form data
		Customer customer = new Customer();
		
		model.addAttribute("customer", customer);
		
		return "customer-form";
	}
	
	@PostMapping("/saveCustomer")
	public String saveCustomer(@ModelAttribute("customer") Customer customer) {
		
		customerService.saveCustomer(customer);
		
		return "redirect:/customer/list";
	}
	
	@GetMapping("/showFormForUpdate")
	public String showFormForUpdate(@RequestParam("customerId") int id, 
			Model model) {
		//get the customer from the service
		Customer customer = customerService.getCustomer(id);
		
		//set customer as a model attribute to pre-populate the form
		model.addAttribute("customer", customer);
		
		//send over to our form
		return "customer-form";
	}
	
	@GetMapping("/delete")
	public String deleteCustomer(@RequestParam("customerId") int id) {
		customerService.deleteCustomer(id);
		
		return "redirect:/customer/list";
	}
	
	@GetMapping("/search")
	public String searchCustomers(@RequestParam("searchName") String searchName,
	                                    Model model) {
		// search customers from the service
	    List<Customer> customers = customerService.searchCustomers(searchName);
	                
	    // add the customers to the model
	    model.addAttribute("customers", customers);
	    
	    return "list-customers";        
	}
}
