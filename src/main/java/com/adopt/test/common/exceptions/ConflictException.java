package com.adopt.test.common.exceptions;

import com.adopt.test.common.messageError.MessageError;

public class ConflictException extends RuntimeException {
    public final MessageError  messageError;
    public ConflictException(MessageError messageError) {

        this.messageError = messageError;
    }
}
