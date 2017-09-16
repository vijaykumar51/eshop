package com.eshop.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;

@Document
public class UserCredentialsDetails {

	@Id
	@Indexed(unique = true)
	private String email;
	
	private String encryptedPassword;
	
	private String privateKey;

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}
	
	public String getEncryptedPassword() {
		return encryptedPassword;
	}

	public void setEncryptedPassword(String encryptedPassword) {
		this.encryptedPassword = encryptedPassword;
	}

	public String getPrivateKey() {
		return privateKey;
	}

	public void setPrivateKey(String privateKey) {
		this.privateKey = privateKey;
	}

	@Override
	public String toString() {
		return "UserCredentialsDetails [email=" + email + ", encryptedPassword=" + encryptedPassword + ", privateKey="
				+ privateKey + "]";
	}
	
}
