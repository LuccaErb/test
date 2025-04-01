package com.adopt.test.exceptions;

public class AnimalAlreadyAdoptedException extends RuntimeException{
    public AnimalAlreadyAdoptedException(String message) {
        super(message);
    }
}
