package com.eshop.service;

public interface SecureCredentialService {

	public String encryptPassword(String plainTextPassword);
	
	public boolean checkPasswordValidity(String plainTextPassword, String encryptedPassword);
	
	public String getTokenForRest();
}
