package com.eshop.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class BaseController {
	
	final private static Logger logger = LoggerFactory.getLogger(BaseController.class);
	
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public ModelAndView welcome(ModelAndView mav) {
		logger.debug("inside welcome funciton");
		mav.addObject("message", "welcome user");
		mav.setViewName("index");
		return mav;
	}
	
	@RequestMapping(value = "/{name}", method = RequestMethod.GET)
	public ModelAndView welcomeName(@PathVariable String name, ModelAndView mav) {
		logger.debug("inside welcome name function");
		mav.addObject("message", "welcome " + name);
		mav.setViewName("index");
		return mav;
	}
	
}
