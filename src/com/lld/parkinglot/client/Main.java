package com.lld.parkinglot.client;

import com.lld.parkinglot.exception.SlotNotFoundException;
import com.lld.parkinglot.model.Slot;
import com.lld.parkinglot.model.SlotType;
import com.lld.parkinglot.model.Vehicle;
import com.lld.parkinglot.model.VehicleType;
import com.lld.parkinglot.service.ParkingLotService;
import com.lld.parkinglot.service.SlotService;
import com.lld.parkinglot.strategy.DurationPricingStrategy;
import com.lld.parkinglot.strategy.NearestAllocationStrategy;

public class Main {
    public static void main(String[] args) throws SlotNotFoundException {
        Slot slot1 = new Slot(1, SlotType.COMPACT, 10.0f);
        Slot slot2 = new Slot(2, SlotType.COMPACT, 10.0f);
        Slot slot3 = new Slot(3, SlotType.COMPACT, 10.0f);
        Slot slot4 = new Slot(4, SlotType.HANDICAPPED, 5.0f);
        Slot slot5 = new Slot(5, SlotType.LARGE, 15.0f);
        Vehicle vehicle1 = new Vehicle("NC282", VehicleType.CAR);
        SlotService slotService = SlotService.SLOT_SERVICE;
        slotService.addSlot(slot1);
        slotService.addSlot(slot2);
        slotService.addSlot(slot3);
        slotService.addSlot(slot4);
        slotService.addSlot(slot5);
        ParkingLotService parkingLotService = new ParkingLotService(new NearestAllocationStrategy(), new DurationPricingStrategy());
        int slotNumber = parkingLotService.allocateSlot(vehicle1);
        System.out.println("Allocated Slot Number = "+slotNumber);
        try {
            Thread.sleep(10000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        Float price = parkingLotService.deallocateSlot(vehicle1);
        System.out.println("Total price : "+price);
    }
}
