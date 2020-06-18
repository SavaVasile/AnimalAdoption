package com.sda.animal_adoption.exceptions;

public class UserNotFoundException extends NullPointerException {
    public UserNotFoundException(String message){
        super(message);
    }
}
