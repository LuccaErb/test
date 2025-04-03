package com.adopt.test.common.exceptions;

import com.adopt.test.common.messageError.MessageError;

public class LimiteExceededException extends RuntimeException{
    private final MessageError messageError;
    public LimiteExceededException(MessageError messageError) {

        this.messageError = messageError;
    }
}
