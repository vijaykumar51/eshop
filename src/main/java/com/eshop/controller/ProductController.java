package com.eshop.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.eshop.model.ProductDetails;
import com.eshop.mongoRepo.ProductRepo;

@Controller
public class ProductController {

	final private static Logger logger = LoggerFactory.getLogger(SellerController.class);

	@Autowired
	ProductRepo productRepo;

	@RequestMapping(value = "/product", method = RequestMethod.POST)
	public ResponseEntity<ProductDetails> addNewProduct(@ModelAttribute ProductDetails productDetails) {
		logger.info("product form details = " + productDetails);
		ProductDetails insertedProduct = productRepo.insert(productDetails);
		logger.info("product inserted details = " + insertedProduct);
		return new ResponseEntity<ProductDetails>(insertedProduct, HttpStatus.CREATED);
	}

	@RequestMapping(value = "/products", method = RequestMethod.GET)
	public ResponseEntity<List<ProductDetails>> getProductDetails() {
		List<ProductDetails> products = productRepo.findAll();
		logger.info("all products = " + products);

		return new ResponseEntity<List<ProductDetails>>(products, HttpStatus.ACCEPTED);
	}

}
