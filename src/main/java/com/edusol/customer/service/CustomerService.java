package com.edusol.customer.service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.edusol.customer.model.Customer;
//import com.edusol.customer.model.Product;
import com.edusol.customer.repository.CustomerRepository;
import com.edusol.customer.model.Product;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;



@Service
public class CustomerService {
	
	@Autowired
	CustomerRepository custRepo;
	private final Logger logger = LoggerFactory.getLogger(this.getClass());

	
	  @Autowired RestTemplate template;
	 
	
		
		  Product a; List<Product> p;
		 
	Customer c;


	public String addCustomer(Customer c) {
		custRepo.save(c);
		return "Customer Added Successfully";
	}

	public Object getCustomer() {
		
		return custRepo.findAll();
	}
	
    public Boolean checkCustomer(int cid) {
		
		return custRepo.existsById(cid);
	}

	
		public ResponseEntity<String> deleteUser(int id) {
			logger.info("record deleted successfully"+id);
			String message="";
			try {
				Customer customer=custRepo.getOne(id);
			
			custRepo.deleteById(id);;;
			logger.info(message);
			return new ResponseEntity<String>(message,HttpStatus.OK);
			}catch (Exception e) {
				logger.error("not found");
				logger.error(message);
				return new ResponseEntity<String> (message,HttpStatus.NOT_FOUND);
				
			}
	}	
		//@HystrixCommand(fallbackMethod = "showfallback")
		public List<Product> getProducts() {
			 final String url = "http://localhost:2331/product";
			
			HttpHeaders header = new HttpHeaders();
			header.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));

			HttpEntity<String> entity = new HttpEntity<String>(header);
			ResponseEntity<Product[]> response = template.exchange(url, HttpMethod.GET, entity, Product[].class);

			List<Product> prod = Arrays.asList(response.getBody());
			return prod;
		}


	
}
