package com.stackroute.userservices.exceptions;

public abstract class UserException extends Exception{
    public UserException (String msg){
        super(msg);
    }
}
