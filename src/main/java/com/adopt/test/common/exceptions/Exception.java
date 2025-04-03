package com.adopt.test.common.exceptions;

import com.adopt.test.common.messageError.MessageError;

public class Exception extends RuntimeException{
    public final MessageError messageError;

    public Exception(MessageError messageError) {

        this.messageError = messageError;
    }
}
