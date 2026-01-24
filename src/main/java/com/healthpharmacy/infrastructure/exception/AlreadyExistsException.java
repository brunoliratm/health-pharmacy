package com.healthpharmacy.infrastructure.exception;

public class AlreadyExistsException extends  RuntimeException {
    public AlreadyExistsException(String message) {
        super(message);
    }
}
