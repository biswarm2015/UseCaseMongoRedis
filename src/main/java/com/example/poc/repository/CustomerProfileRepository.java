package com.example.poc.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.example.poc.document.CustomerProfileData;

public interface CustomerProfileRepository extends MongoRepository<CustomerProfileData, String>{
	
	CustomerProfileData findByCustomerId(String customerId);

}
