package org.example.exception;

public class BookDoesNotExistException extends RuntimeException {
    public BookDoesNotExistException(String message) {
        super("Book does not exist");
    }
}
