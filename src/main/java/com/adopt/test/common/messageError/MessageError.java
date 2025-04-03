package com.adopt.test.common.messageError;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;

@JsonSerialize(using = MessageErrorSerializer.class)
public enum MessageError {
    ANIMAL_NOT_FOUND(404,"Animal not found","Animal not found"),
    ANIMAL_ADOPTED(400,"Animal already adopted","Animal already adopted"),
    ANIMAL_NOT_CREATED(400,"Animal not created","Animal not created"),
    ADOPTER_NOT_FOUND(404,"Adopter not found","Adopter not found"),
    ADOPTER_NOT_CREATED(400,"Adopter not created","Adopter not created"),
    ADOPTION_NOT_FOUND(404,"Adoption not found","Adoption not found"),
    ADOPTION_LIMIT_EXCEEDED(400,"Adoption limit exceeded","Adoption limit exceeded"),
    ANIMAL_ALREADY_ADOPTED(400,"Animal already adopted","Animal already adopted");
    private final int status;

    private final String code;

    private final String message;

    MessageError(int status, String code, String message) {
        this.status = status;
        this.code = code;
        this.message = message;
    }
    public int getStatus() {
        return status;
    }

    public String getCode() {
        return code;
    }

    public String getMessage() {
        return message;
    }

}
