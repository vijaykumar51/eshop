package com.eshop.mongoRepo;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.eshop.model.ProductDetails;

public interface ProductRepo extends MongoRepository<ProductDetails, String> {

}
