package org.example.exception;

public class staffInvalidLoginException extends RuntimeException {
    public staffInvalidLoginException(String message) {
        super(message);
    }
}
