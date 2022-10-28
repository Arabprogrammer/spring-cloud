package com.customer.app.service;

import org.springframework.stereotype.Service;

import com.customer.app.entity.Customer;
import com.customer.app.repo.CustomerRepo;

@Service
public record CustomerService(CustomerRepo customerRepo) {

	public void registerCustomer(CustomerRegistrationRequest request) {
//		TODO: check if Email valid
//		TODO: check if Email not taken
//		TODO: check if fraudster
		Customer cus = Customer.builder().firstName(request.firstName()).lastName(request.lastName())
				.email(request.email()).build();
		customerRepo.save(cus);
//		TODO: send notification
	}

}
