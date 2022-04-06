package com.edusol.customer;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker;
import org.springframework.cloud.netflix.hystrix.EnableHystrix;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;


@SpringBootApplication
@EnableHystrix
@EnableCircuitBreaker

public class CustomerApplication {

	public static void main(String[] args) {
		SpringApplication.run(CustomerApplication.class, args);
	}
	@Bean
	public RestTemplate getRestTemplate() 
	{
		return new RestTemplate();
	}
	

}
