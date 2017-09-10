package com.eshop.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
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
	private UserRegistrationRepo userRepo;
	
	@RequestMapping(value="/users", method = RequestMethod.GET)
	public ResponseEntity<List<UserRegistrationDetails>> getUsers(){
		List<UserRegistrationDetails> users = userRepo.findAll();
		return new ResponseEntity<List<UserRegistrationDetails>>(users, HttpStatus.OK);
	}

	@RequestMapping(value="/users", method = RequestMethod.POST)
	public ResponseEntity<UserRegistrationDetails> registerUser(@ModelAttribute UserRegistrationDetails userDetails) {
	
		if(userRepo.exists(userDetails.getName())) {
			return new ResponseEntity<UserRegistrationDetails>(HttpStatus.CONFLICT);
		} else {
			UserRegistrationDetails userSavedDetails = userRepo.insert(userDetails);
			return new ResponseEntity<UserRegistrationDetails>(userSavedDetails, HttpStatus.CREATED);
		}
		
	}
	
	@RequestMapping(value="/users/{name}", method = RequestMethod.GET)
	public ResponseEntity<UserRegistrationDetails> registerUser(@PathVariable String name) {
		UserRegistrationDetails userDetails = userRepo.findByName(name);
		logger.info("userDetails = " + userDetails);
		if(userDetails == null) {
			return new ResponseEntity<UserRegistrationDetails>(HttpStatus.NO_CONTENT);
		}
		return new ResponseEntity<UserRegistrationDetails>(userDetails, HttpStatus.OK);
	}
	
}
