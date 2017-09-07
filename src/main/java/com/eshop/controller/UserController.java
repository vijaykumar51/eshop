package com.eshop.controller;

import java.util.HashMap;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoOperations;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.eshop.model.UserRegistrationDetails;
import com.eshop.mongoRepo.UserRegisterationRepo;

@Controller
public class UserController {
	
	final private static Logger logger = LoggerFactory.getLogger(UserController.class);

	@Autowired
	private MongoOperations mongoOps;
	
	@Autowired
	private UserRegisterationRepo userRepo;
	
	@RequestMapping(value="/user/{id}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	public Map<String, Object> registerUser(@PathVariable String id) {
		Map<String, Object> dataMap = new HashMap<String, Object>();
		  dataMap.put("message", "Booking created successfully");
		  dataMap.put("status", "1");
		  return dataMap;
	}
	
	@RequestMapping(value="/user", method = RequestMethod.POST)
	public boolean registerUser(@ModelAttribute UserRegistrationDetails userDetails) {
		logger.info("userDetails " + userDetails.toString());
		
		mongoOps.insert(userDetails, "UserInfo");
		
		return true;
	}
	
	
}
