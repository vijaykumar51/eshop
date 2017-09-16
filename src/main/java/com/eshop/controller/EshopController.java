package com.eshop.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.eshop.dao.SecureCredentialService;
import com.eshop.model.UserCredentialsDetails;
import com.eshop.mongoRepo.UserCredentialRepo;

@Controller
public class EshopController {
	
	final private static Logger logger = LoggerFactory.getLogger(EshopController.class);
	
	@Autowired
	UserCredentialRepo userCredRepo;
	
	@Autowired
	SecureCredentialService credService;
	
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public ModelAndView welcome(ModelAndView mav) {
		logger.debug("inside welcome funciton");
		mav.addObject("message", "welcome user");
		mav.setViewName("index");
		return mav;
	}
	
	@RequestMapping(value="/login", method = RequestMethod.GET)
	public ModelAndView showLoginScreen(ModelAndView mav) {
		mav.setViewName("login");
		return mav;
	}
	
	@RequestMapping(value="/login", method = RequestMethod.POST)
	public ResponseEntity checkLogin(@RequestParam String email, @RequestParam String password) {
	
		boolean userAuthorized = false;
		
		if(userCredRepo.exists(email)) {
			
			UserCredentialsDetails userCredDetails = userCredRepo.findOne(email);
			logger.info("returned credentials = " + userCredDetails.toString());
			String encryptedPassword = userCredDetails.getEncryptedPassword();
			if(credService.checkPasswordValidity(password, encryptedPassword)) {
				userAuthorized = true;
			}
		}
		
		if(!userAuthorized) {
			return new ResponseEntity(HttpStatus.UNAUTHORIZED);
		}
		
		return new ResponseEntity(HttpStatus.ACCEPTED);
	}
	
	@RequestMapping(value="/register", method = RequestMethod.GET)
	public ModelAndView showRegistrationScreen(ModelAndView mav) {
		mav.setViewName("register");
		return mav;
	}
	
}
