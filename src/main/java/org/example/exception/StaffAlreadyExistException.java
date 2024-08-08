package org.example.exception;

public class StaffAlreadyExistException  extends RuntimeException{
    public StaffAlreadyExistException(String message){
        super("Staff Already Exist");
    }
}
