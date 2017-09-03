package com.eshop.dao;

import java.util.List;

import com.eshop.model.UserRegistrationDetails;

public interface UserDetailsDao {

	List<UserRegistrationDetails> findUserByName(String t);
	
}
