package com.lld.parkinglot.service;

import com.lld.parkinglot.model.Slot;
import com.lld.parkinglot.model.SlotType;
import com.lld.parkinglot.model.VehicleType;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public enum SlotService {
    SLOT_SERVICE;
    Map<Integer, Slot> slots = new HashMap<>();
    public void addSlot(Slot slot){
        slots.put(slot.getNumber(), slot);
    }
    public List<Slot> getAvailableSlots(VehicleType type){
        return slots.values().stream()
                .filter(slot -> slot.isAvailable() && checkSuitability(slot.getSlotType(), type))
                .collect(Collectors.toList());
    }
    private boolean checkSuitability(SlotType slotType, VehicleType vehicleType) {
        if(vehicleType==VehicleType.CAR && (slotType==SlotType.COMPACT || slotType==SlotType.HANDICAPPED)) return true;
        else if(vehicleType==VehicleType.TRUCK && slotType==SlotType.LARGE) return true;
        else return false;
    }
}
