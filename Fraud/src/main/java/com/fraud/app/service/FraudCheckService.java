package com.fraud.app.service;

import java.time.LocalDateTime;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fraud.app.entity.FraudCheckHistory;
import com.fraud.app.repo.FraudCheckHistoryRepo;

@Service
public class FraudCheckService {
	
	@Autowired
	FraudCheckHistoryRepo fraudCheckHistoryRepo;

	public Boolean isFraudulentCustomer(Integer customerId) {
//		TODO: check if customer-id is valid
		Boolean isFraudster= false;
		FraudCheckHistory history  =FraudCheckHistory.builder()
				.customerId(customerId)
				.createdAt(LocalDateTime.now())
				.isFraudster(isFraudster)
				.build(); 
		fraudCheckHistoryRepo.save(history);
		return isFraudster;
	}

}
