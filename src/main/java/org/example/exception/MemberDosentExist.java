package org.example.exception;

public class MemberDosentExist extends RuntimeException{
    public MemberDosentExist(String message) {
        super(message);

    }
}
