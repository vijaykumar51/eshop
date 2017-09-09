package com.eshop.mongoRepo;

import com.eshop.dao.UserDetailsDao;
import com.eshop.model.UserRegistrationDetails;

import org.springframework.data.mongodb.repository.MongoRepository;

public interface UserRegistrationRepo extends MongoRepository<UserRegistrationDetails, String>, UserDetailsDao{
	
	UserRegistrationDetails findByEmail(String email);
	
	UserRegistrationDetails findByName(String name);
	
}