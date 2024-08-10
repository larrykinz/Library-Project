package org.example.exception;

public class BookUpdateAvailabilityException extends RuntimeException {
    public BookUpdateAvailabilityException(String message) {
        super(message);
    }
}
