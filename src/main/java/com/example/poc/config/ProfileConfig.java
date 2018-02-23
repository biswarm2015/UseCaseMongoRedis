package com.example.poc.config;

import org.springframework.cloud.config.java.AbstractCloudConfig;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import org.springframework.data.mongodb.MongoDbFactory;
import org.springframework.data.mongodb.core.MongoTemplate;


public class ProfileConfig {
  
  @Configuration
  @Profile("cloud")
  static class CloudConfiguration extends AbstractCloudConfig {
    
    @Bean
    public MongoDbFactory mongoDbFactory() {
      return connectionFactory().mongoDbFactory();
    }
    
    @Bean
    public MongoTemplate mongoTemplate() {
        return new MongoTemplate(mongoDbFactory());
    }
    
    
    
  }
}