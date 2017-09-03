package com.eshop.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoOperations;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.eshop.model.UserRegistrationDetails;

@Controller
public class EshopController {
	
	@Autowired
	MongoOperations mongo;
	
	final private static Logger logger = LoggerFactory.getLogger(EshopController.class);
	
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public ModelAndView welcome(ModelAndView mav) {
		logger.debug("inside welcome funciton");
		mav.addObject("message", "welcome user");
		mav.setViewName("index");
		return mav;
	}
	
	@RequestMapping(value="/register", method = RequestMethod.GET)
	public ModelAndView registerUser(ModelAndView mav) {
		mav.setViewName("register");
		return mav;
	}
	
	@RequestMapping(value="/register", method = RequestMethod.POST)
	public void registerUser(@ModelAttribute UserRegistrationDetails userDetails) {
		logger.info("userDetails " + userDetails.toString());
		
		mongo.insert(userDetails, "Person");
		
	}
	
	
	
}
