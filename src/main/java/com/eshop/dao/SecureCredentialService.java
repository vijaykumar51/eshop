package com.eshop.dao;

import org.springframework.security.crypto.bcrypt.BCrypt;
import org.springframework.stereotype.Service;

@Service
public class SecureCredentialService {
	
	final private static int bcryptWorkload = 12;
	final private static String hashInitials = "$2a$";

	public String encryptPassword(String plainTextPassword) {
		String salt = BCrypt.gensalt(bcryptWorkload);
		String encryptedPassword = BCrypt.hashpw(plainTextPassword, salt);
		return encryptedPassword;
	}
	
	public boolean checkPasswordValidity(String plainTextPassword, String encryptedPassword) {
		
		if(null == encryptedPassword || !encryptedPassword.startsWith(hashInitials)) {
			throw new java.lang.IllegalArgumentException("Invalid encrypted password hash");
		}
		
		return BCrypt.checkpw(plainTextPassword, encryptedPassword);		
	}
	
	public String getTokenForRest() {
		return null;
	}
	
}
