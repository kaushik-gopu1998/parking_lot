package com.lld.parkinglot.strategy;

import com.lld.parkinglot.exception.SlotNotFoundException;
import com.lld.parkinglot.model.Slot;
import com.lld.parkinglot.model.Vehicle;

public interface AllocationStrategy {
    Slot assignSlot(Vehicle vehicle) throws SlotNotFoundException;
}
