package com.eshop.mongoRepo;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.eshop.model.UserCredentialsDetails;

public interface UserCredentialRepo extends MongoRepository<UserCredentialsDetails, String> {

}
