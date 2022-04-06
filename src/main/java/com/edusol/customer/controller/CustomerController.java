package com.edusol.customer.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.edusol.customer.model.Customer;
import com.edusol.customer.service.CustomerService;



@RestController
@RequestMapping("/cust")
public class CustomerController {
	
	@Autowired
	CustomerService customerservice;

	@PostMapping("/add")
	public String addCustomer(@RequestBody Customer c)
	{
		return customerservice.addCustomer(c);
	}
	
	@GetMapping("/get")
	public Object getCustomer()
	{
		return customerservice.getCustomer();
	}
	
	
	@GetMapping("/get-prod")
	public Object getProducts()
	{
		return customerservice.getProducts();
	}
	
	
	
	
	@GetMapping("/check")
	public Boolean checkCustomer(@RequestParam int cid)
	{
		return customerservice.checkCustomer(cid);
	}
	@DeleteMapping("/{id}")
	public ResponseEntity<String> deleteUser(@PathVariable int id) {
		return customerservice.deleteUser(id);
	
}
	}