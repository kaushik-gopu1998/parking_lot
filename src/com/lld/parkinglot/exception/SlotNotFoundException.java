package com.lld.parkinglot.exception;

public class SlotNotFoundException extends Exception{
    public SlotNotFoundException(){}
    public SlotNotFoundException(String message){
        super(message);
    }
}
