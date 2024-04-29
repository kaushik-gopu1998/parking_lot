package com.lld.parkinglot.model;

public class VehicleLotRecord {
    private Slot slot;
    private Vehicle vehicle;
    private Long entryTime;
    private Long exitTime;
    public VehicleLotRecord(Slot theSlot, Vehicle theVehicle, Long theEntryTime, Long theExitTime){
        slot=theSlot;
        vehicle=theVehicle;
        entryTime=theEntryTime;
        exitTime=theExitTime;
    }

    public Slot getSlot() {
        return slot;
    }

    public Vehicle getVehicle() {
        return vehicle;
    }

    public long getEntryTime() {
        return entryTime;
    }

    public long getExitTime() {
        return exitTime;
    }

    public void setExitTime(Long exitTime) {
        this.exitTime = exitTime;
    }
}
