package org.example.exception;

public class MemberAlreadyExist extends RuntimeException {
    public MemberAlreadyExist(String message) {
        super(message);
    }
}

