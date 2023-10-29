package com.webproject.api.controllers;


import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping(value ="/customer")
public class CustomerController {
	
	private CustomerController customerRepository;
	
	public CustomerController(CustomerController customerController) {
		super();
		this.customerRepository = customerRepository;
	}
	
	@PostMapping
	
	

}
