package com.onlinestore.zemoso.exception;

public class UserNotFoundException extends RuntimeException {
	public UserNotFoundException(String username) {
		super(String.format("user not found with username %s", username));
	}
}
