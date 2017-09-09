package com.eshop.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoOperations;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.eshop.model.UserRegistrationDetails;
import com.eshop.mongoRepo.UserRegistrationRepo;

@RestController
public class UserController {
	
	final private static Logger logger = LoggerFactory.getLogger(UserController.class);

	@Autowired
	private MongoOperations mongoOps;
	
	@Autowired
	private UserRegistrationRepo userRepo;
	
	@RequestMapping(value="/user/{name}", method = RequestMethod.GET)
	public ResponseEntity<UserRegistrationDetails> registerUser(@PathVariable String name) {
		UserRegistrationDetails userDetails = userRepo.findByName(name);
		logger.info("userDetails = " + userDetails);
		if(userDetails == null) {
			return new ResponseEntity<UserRegistrationDetails>(HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity<UserRegistrationDetails>(userDetails, HttpStatus.OK);
	}
	
	@RequestMapping(value="/user", method = RequestMethod.POST)
	public boolean registerUser(@ModelAttribute UserRegistrationDetails userDetails) {
		logger.info("userDetails " + userDetails.toString());
		
		mongoOps.insert(userDetails, "UserInfo");
		
		return true;
	}
	
	
}
