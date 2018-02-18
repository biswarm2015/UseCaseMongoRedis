package com.example.poc.services;

import com.example.poc.document.CustomerProfileData;

public interface CustomerProfileService {
	
	Long count();
	
	CustomerProfileData save(CustomerProfileData profile);

	CustomerProfileData findCustomerByCustomerId(String customerId);

	CustomerProfileData updateAddressByCustomerId(String customerId, String address);
	
	CustomerProfileData updateMobileNosByCustomerId(String customerId, String mobileNo);
	
	CustomerProfileData updateEmailIdByCustomerId(String customerId, String emailId);

    void deleteCustomerProfileData(String customerId);

    void deleteAllCache();

    void deleteAllCollections();

}
