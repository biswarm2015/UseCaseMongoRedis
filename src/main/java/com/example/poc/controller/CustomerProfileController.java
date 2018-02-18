package com.example.poc.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.poc.document.CustomerProfileData;
import com.example.poc.services.CustomerProfileService;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping(value = "/customerProfile")
@RequiredArgsConstructor
public class CustomerProfileController {
	
	@Autowired
	private CustomerProfileService service;
	
	 
    @PostMapping(value = "/saveCustomerProfileData")
    public CustomerProfileData saveCustomerProfileData(CustomerProfileData profile) {
        return service.save(profile);
    }

    @GetMapping(value = "/findByCustomerId/{customerId}")
    @Cacheable(value = "customerProfileData", key = "#customerId", unless = "#result == null")
    public CustomerProfileData findCustomerProfileDataByCustomerId(@PathVariable String customerId) {
        return service.findCustomerByCustomerId(customerId);
    }
   
   
    @PutMapping(value = "/updateAddressByCustomerId/{customerId}/{address}")
    @CachePut(value = "customerProfileData", key = "#customerId")
    public CustomerProfileData updateAddressByCustomerId(@PathVariable(value = "customerId") String customerId,
            @PathVariable(value = "address") String address) {
        return service.updateAddressByCustomerId(customerId, address);
    }
    
    @PutMapping(value = "/updateMobileNoByCustomerId/{customerId}/{mobileNo}")
    @CachePut(value = "customerProfileData", key = "#customerId")
    public CustomerProfileData updateMobileNoByCustomerId(@PathVariable(value = "customerId") String customerId,
            @PathVariable(value = "mobileNo") String mobileNo) {
        return service.updateMobileNosByCustomerId(customerId, mobileNo);
    }
    
    @PutMapping(value = "/updateEmailIdByCustomerId/{customerId}/{emailId}")
    @CachePut(value = "customerProfileData", key = "#customerId")
    public CustomerProfileData updateEmailIdByCustomerId(@PathVariable(value = "customerId") String customerId,
            @PathVariable(value = "emailId") String emailId) {
        return service.updateEmailIdByCustomerId(customerId,  emailId);
    }

    
    @DeleteMapping(value = "/deleteByCustomerId/{customerId}")
    @CacheEvict(value = "customerProfileData", key = "#customerId")
    public String deleteByCustomerId(@PathVariable(value = "customerId") String customerId) {
        final CustomerProfileData profile = this.findCustomerProfileDataByCustomerId(customerId);
        if (null != profile) {
            this.service.deleteCustomerProfileData(profile.getId());
            return "CustomerProfileData with id " + customerId + " deleted";
        } else {
            return "CustomerProfileData with id " + customerId + " Not Found";
        }
    }

   
    @GetMapping(value = "/deleteCache")
    @CacheEvict(value = "customerProfileData", allEntries = true)
    public void deleteCache() {
        this.service.deleteAllCache();
    }

  
    public Long count() {
        return this.service.count();
    }

  
    public void deleteAll() {
        this.service.deleteAllCollections();
    }

	
	

}
