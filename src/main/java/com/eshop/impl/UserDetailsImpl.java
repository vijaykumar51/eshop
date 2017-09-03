package com.eshop.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoOperations;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;

import com.eshop.dao.UserDetailsDao;
import com.eshop.model.UserRegistrationDetails;

public class UserDetailsImpl implements UserDetailsDao{

	@Autowired
	MongoOperations mongo;
	
	@Override
	public List<UserRegistrationDetails> findUserByName(String name) {
		// TODO Auto-generated method stub
		
		Query query = new Query(Criteria.where("name").is(name));
		
		mongo.find(query, UserRegistrationDetails.class);
		
		return null;
	}

}
