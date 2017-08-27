package com.eshop.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class BaseController {
	
	final static Logger logger = LoggerFactory.getLogger(BaseController.class);
	
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String welcome(ModelMap model) {
		logger.debug("inside welcome funciton");
		model.addAttribute("message", "Welcome User");
		return "index";
	}
	
	@RequestMapping(value = "/{name}", method = RequestMethod.GET)
	public String welcomeName(@PathVariable String name, ModelMap model) {
		logger.debug("inside welcome name function");
		logger.info("new welcome name tttttttttttttt");
		model.addAttribute("message", "Welcome " + name);
		return "index";
	}
	
}
