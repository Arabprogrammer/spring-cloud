package com.fraud.app.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.fraud.app.service.FraudCheckService;

@RequestMapping("api/v1/fraud-check")
public class FraudCheckController {

	@Autowired
	FraudCheckService fraudCheckService;

	@GetMapping(path = "{customerId}")
	public FraudCheckRespone isFraudster(FraudCheckRespone response, @PathVariable Integer customerId) {

		return new FraudCheckRespone(fraudCheckService.isFraudulentCustomer(customerId));
	}

}
