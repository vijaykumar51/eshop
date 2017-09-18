package com.eshop.controller.seller;

//import org.slf4j.LoggerFactory;
//import org.slf4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/seller")
public class SellerController {

	//final private static Logger logger = LoggerFactory.getLogger(SellerController.class);
	
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public ModelAndView getSellerHome(ModelAndView mav) {
		mav.setViewName("seller");
		return mav;
	}
	
	@RequestMapping(value = "/profile", method = RequestMethod.GET)
	public ModelAndView getSellerProfile(ModelAndView mav) {
		mav.setViewName("seller-profile");
		return mav;
	}
	
}
