package com.customer.app.controller;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.customer.app.service.CustomerRegistrationRequest;
import com.customer.app.service.CustomerService;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@RestController
@RequestMapping("api/v1/customers")
public record CustomerController(CustomerService cusService) {
	
	@PostMapping
	public void register(@RequestBody CustomerRegistrationRequest cus) {
		log.info("neuw Customer registration{}",cus);
		cusService.registerCustomer(cus);
	}

}
