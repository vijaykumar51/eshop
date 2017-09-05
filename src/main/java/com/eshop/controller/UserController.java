package com.eshop.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoOperations;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.eshop.model.UserRegistrationDetails;

@RestController
public class UserController {
	
	final private static Logger logger = LoggerFactory.getLogger(UserController.class);

	@Autowired
	MongoOperations mongoOps;
	
	@RequestMapping(value="/user/{id}", method = RequestMethod.GET)
	@ResponseBody
	public String registerUser(@PathVariable String id) {
		
		return id;
	}
	
	@RequestMapping(value="/user", method = RequestMethod.POST)
	@ResponseBody
	public void registerUser(@ModelAttribute UserRegistrationDetails userDetails) {
		logger.info("userDetails " + userDetails.toString());
		
		mongoOps.insert(userDetails, "UserInfo");
	}
	
	
}
