package com.onlinestore.zemoso.exception;

public class UserNotSavedException extends RuntimeException {
    public UserNotSavedException() {
        super("user not saved");
    }
}