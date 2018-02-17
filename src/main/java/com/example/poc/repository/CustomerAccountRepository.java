package com.example.poc.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.example.poc.document.CustomerAccount;

public interface CustomerAccountRepository extends MongoRepository<CustomerAccount, Long>{

}
