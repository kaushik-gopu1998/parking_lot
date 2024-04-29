package com.lld.parkinglot.model;

public class Vehicle {
    private final String number;
    private  VehicleType type;
    public Vehicle(final String theNumber,VehicleType theType){
        number=theNumber;
        type=theType;
    }

    public String getNumber() {
        return number;
    }

    public VehicleType getType() {
        return type;
    }
}
