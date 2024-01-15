package com.example.myfirstwebapp.login;

import org.springframework.stereotype.Service;

@Service
public class AuthenticationService {
	private final String USERNAME = "baonguyen";
	private final String PASSWORD = "thaibao3303";	
	
	public boolean authenticate(String username, String password) {
		boolean isValidUsername = username.equalsIgnoreCase(USERNAME);
		boolean isValidPassword = password.equalsIgnoreCase(PASSWORD);
		return isValidPassword && isValidUsername;
	}
}
