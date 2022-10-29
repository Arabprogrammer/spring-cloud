package com.customer.app.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.customer.app.entity.Customer;
import com.customer.app.repo.CustomerRepo;
import com.fraud.app.controller.FraudCheckRespone;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class CustomerService {
	
	@Autowired
	CustomerRepo customerRepo;
	@Autowired
	RestTemplate restTemplate;

	public void registerCustomer(CustomerRegistrationRequest request) {
//		TODO: check if Email valid
//		TODO: check if Email not taken
//		TODO: check if fraudster
		Customer cus = Customer.builder().firstName(request.firstName()).lastName(request.lastName())
				.email(request.email()).build();
		customerRepo.saveAndFlush(cus);
		String url = "http://localhost:8081/api/v1/fraud-check/{customerId}";
		FraudCheckRespone fraudCheckRespone = restTemplate.getForObject
				(url, FraudCheckRespone.class, cus.getId());
		if(fraudCheckRespone.isFraudster()) {
			throw new IllegalStateException("Fraudster");
		}
//		TODO: send notification
	}

}
