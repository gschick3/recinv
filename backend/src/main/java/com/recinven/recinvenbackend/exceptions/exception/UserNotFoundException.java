package com.recinven.recinvenbackend.exceptions.exception;

public class UserNotFoundException extends RuntimeException{
    public UserNotFoundException(Long userId) {
        super("Could not find user " + userId);
    }
}
