package com.lld.parkinglot.service;

import com.lld.parkinglot.exception.SlotNotFoundException;
import com.lld.parkinglot.model.Slot;
import com.lld.parkinglot.model.Vehicle;
import com.lld.parkinglot.model.VehicleLotRecord;
import com.lld.parkinglot.strategy.AllocationStrategy;
import com.lld.parkinglot.strategy.PricingStrategy;

import java.util.HashMap;
import java.util.Map;

public class ParkingLotService {
    private AllocationStrategy allocationStrategy;
    private PricingStrategy pricingStrategy;
    private Map<String, VehicleLotRecord> records = new HashMap<>();
    public ParkingLotService(AllocationStrategy theAllocationStrategy, PricingStrategy thePricingStrategy){
        allocationStrategy=theAllocationStrategy;
        pricingStrategy=thePricingStrategy;
    }
    public int allocateSlot(Vehicle vehicle) throws SlotNotFoundException {
        Slot slot = allocationStrategy.assignSlot(vehicle);
        VehicleLotRecord record = new VehicleLotRecord(slot, vehicle, System.currentTimeMillis(), null);
        records.put(vehicle.getNumber(), record);
        return slot.getNumber();
    }
    public Float deallocateSlot(Vehicle vehicle){
        VehicleLotRecord record = records.get(vehicle.getNumber());
        record.setExitTime(System.currentTimeMillis());
        Float price = pricingStrategy.calculatePrice(record,record.getSlot().getPrice());
        record.getSlot().updateAvailability();
        return price;
    }
}
