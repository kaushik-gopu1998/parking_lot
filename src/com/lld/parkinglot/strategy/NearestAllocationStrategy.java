package com.lld.parkinglot.strategy;

import com.lld.parkinglot.exception.SlotNotFoundException;
import com.lld.parkinglot.model.Slot;
import com.lld.parkinglot.model.Vehicle;
import com.lld.parkinglot.service.SlotService;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class NearestAllocationStrategy implements AllocationStrategy{
    @Override
    public Slot assignSlot(Vehicle vehicle) throws SlotNotFoundException {
        SlotService slotService = SlotService.SLOT_SERVICE;
        List<Slot> availableSlots = slotService.getAvailableSlots(vehicle.getType());
        if(availableSlots.isEmpty()) throw new SlotNotFoundException("Sorry, No slots available at this time");
        Collections.sort(availableSlots, Comparator.comparingInt(Slot::getNumber));
        return availableSlots.getFirst();
    }
}
