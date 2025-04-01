package com.adopt.test.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.BAD_REQUEST)
public class AdoptionLimitExceededException extends RuntimeException{
    public AdoptionLimitExceededException(String message) {
        super(message);
    }
}
