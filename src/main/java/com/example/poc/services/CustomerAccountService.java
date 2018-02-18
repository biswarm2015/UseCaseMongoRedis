package com.example.poc.services;

import com.example.poc.document.CustomerAccount;

public interface CustomerAccountService {
	
	Long count();
	
	CustomerAccount save(CustomerAccount account);

	CustomerAccount findCustomerAccountByAccountNumber(Long accountNumber);

	CustomerAccount updateByAccountNumber(Long accountNumber, String accountType, Long transactionAmount, String transactionType);

    void deleteCustomerAccount(Long accountNumber);

    void deleteAllCache();

    void deleteAllCollections();

}
