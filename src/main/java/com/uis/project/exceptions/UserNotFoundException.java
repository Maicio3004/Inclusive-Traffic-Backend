package com.uis.project.exceptions;

public class UserNotFoundException extends RuntimeException {

    public UserNotFoundException(Long userId) {
        super("User with id " + userId + " not found");
    }

    public UserNotFoundException(String field, String value) {
        super("User with " + field + " = " + value + " not found");
    }

}
