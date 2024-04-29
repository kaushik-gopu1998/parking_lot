package com.lld.parkinglot.model;

public class Slot {
    private int number;
    private SlotType slotType;
    private boolean isAvailable;
    private Float price;
    public Slot(int theNumber, SlotType theSlotType, Float thePrice){
        number=theNumber;
        slotType=theSlotType;
        price=thePrice;
        isAvailable=true;
    }

    public int getNumber() {
        return number;
    }

    public SlotType getSlotType() {
        return slotType;
    }

    public boolean isAvailable() {
        return isAvailable;
    }
    public void updateAvailability(){
        this.isAvailable = !this.isAvailable;
    }

    public Float getPrice() {
        return price;
    }

    public void setPrice(Float price) {
        this.price = price;
    }
}
