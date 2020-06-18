package com.sda.animal_adoption.exceptions;

public class AnimalNotFoundException extends NullPointerException {
    public AnimalNotFoundException(String message){
        super(message);
    }
}
