package com.eshop.controller.seller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/seller")
public class ProductController {

	final private static Logger logger = LoggerFactory.getLogger(SellerController.class);

	@RequestMapping(value = "/add-product", method = RequestMethod.GET)
	public ModelAndView getAddProductPage(ModelAndView mav) {
		mav.setViewName("seller/add-product");
		return mav;
	}

}
