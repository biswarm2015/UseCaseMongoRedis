package com.example.poc.services;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.FindAndModifyOptions;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;
import org.springframework.stereotype.Service;

import com.example.poc.document.CustomerProfileData;
import com.example.poc.repository.CustomerProfileRepository;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@RequiredArgsConstructor
@Service
@Slf4j
public class CustomerProfileServiceImpl implements CustomerProfileService{
	
	private static final Logger log= LoggerFactory.getLogger(CustomerProfileServiceImpl.class);

	@Autowired
	private CustomerProfileRepository repository;
	
	@Autowired
    private MongoTemplate mongoTemplate;

	@Override
	public Long count() {
		return this.repository.count();
	}

	@Override
	public CustomerProfileData save(CustomerProfileData profile) {
		 log.info("Saving customer profile data :{}", profile);
	     return this.repository.save(profile);
	}

	@Override
	public CustomerProfileData findCustomerByCustomerId(String customerId) {
		log.info("Finding CustomerProfileData by CustomerId :{}", customerId);
        return this.repository.findByCustomerId(customerId);
	}

	@Override
	public CustomerProfileData updateAddressByCustomerId(String customerId, String address) {
		log.info("Updating CustomerProfileData address, mobileNo and emailId by customerId :{} with {}", customerId, address);
        final Query query = new Query(Criteria.where("customerId").is(customerId));
        final Update update = new Update().set("address", address);
        return this.mongoTemplate.findAndModify(query, update,
                new FindAndModifyOptions().returnNew(true).upsert(false), CustomerProfileData.class);
	}

	@Override
	public void deleteCustomerProfileData(String customerId) {
		 log.info("deleting CustomerProfileData by customerId :{}", customerId);
	        this.repository.delete(customerId);
		
	}

	@Override
    public void deleteAllCache() {
        log.info("Deleting Cache");
    }

    @Override
    public void deleteAllCollections() {
        this.repository.deleteAll();
    }

	@Override
	public CustomerProfileData updateMobileNosByCustomerId(String customerId, String mobileNo) {
		log.info("Updating CustomerProfileData address, mobileNo and emailId by customerId :{} with {}", customerId, mobileNo);
        final Query query = new Query(Criteria.where("customerId").is(customerId));
        final Update update = new Update().set("mobileNo", mobileNo);
        return this.mongoTemplate.findAndModify(query, update,
                new FindAndModifyOptions().returnNew(true).upsert(false), CustomerProfileData.class);
	}

	@Override
	public CustomerProfileData updateEmailIdByCustomerId(String customerId, String emailId) {
		log.info("Updating CustomerProfileData address, mobileNo and emailId by customerId :{} with {}", customerId, emailId);
        final Query query = new Query(Criteria.where("customerId").is(customerId));
        final Update update = new Update().set("emailId", emailId);
        return this.mongoTemplate.findAndModify(query, update,
                new FindAndModifyOptions().returnNew(true).upsert(false), CustomerProfileData.class);
	}

}
