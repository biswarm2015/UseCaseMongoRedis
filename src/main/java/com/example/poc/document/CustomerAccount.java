package com.example.poc.document;

import java.io.Serializable;

import org.springframework.data.mongodb.core.mapping.Document;

import lombok.Data;

@Data
@Document
public class CustomerAccount implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	//private String customerId;
	private Long accountNumber;
	private String accountType;
	private Long previousBalance;
	private Long currentBalance;
	private String transactionType;
	public Long getAccountNumber() {
		return accountNumber;
	}
	public void setAccountNumber(Long accountNumber) {
		this.accountNumber = accountNumber;
	}
	public String getAccountType() {
		return accountType;
	}
	public void setAccountType(String accountType) {
		this.accountType = accountType;
	}
	public Long getPreviousBalance() {
		return previousBalance;
	}
	public void setPreviousBalance(Long previousBalance) {
		this.previousBalance = previousBalance;
	}
	public Long getCurrentBalance() {
		return currentBalance;
	}
	public void setCurrentBalance(Long currentBalance) {
		this.currentBalance = currentBalance;
	}
	public String getTransactionType() {
		return transactionType;
	}
	public void setTransactionType(String transactionType) {
		this.transactionType = transactionType;
	}
	
	
	
}
