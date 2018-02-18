package com.example.poc.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

import com.example.poc.controller.CustomerProfileController;
import com.example.poc.document.CustomerProfileData;

import lombok.RequiredArgsConstructor;


@Component
@RequiredArgsConstructor
public class DataLoader implements ApplicationRunner {

	@Autowired
	private CustomerProfileController customerProfileController;

    
    @Override
    public void run(ApplicationArguments args) throws Exception {
        final Long count1 = customerProfileController.count();
        if(count1 == 0) {
        	final CustomerProfileData customerProfileData = new CustomerProfileData();
        	customerProfileData.setCustomerId("12345678");
        	customerProfileData.setCustomerName("Mr. XYZ");
        	customerProfileData.setAddress("Hyderabad");
        	customerProfileData.setMobileNo("9876543210");
        	customerProfileData.setEmailId("xyz@mail.com");
        	customerProfileController.saveCustomerProfileData(customerProfileData);
        }
    }
}