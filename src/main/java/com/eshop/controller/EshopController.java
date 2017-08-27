package com.eshop.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class EshopController {
	
	final private static Logger logger = LoggerFactory.getLogger(EshopController.class);
	
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public ModelAndView welcome(ModelAndView mav) {
		logger.debug("inside welcome funciton");
		mav.addObject("message", "welcome user");
		mav.setViewName("index");
		return mav;
	}
	
}
