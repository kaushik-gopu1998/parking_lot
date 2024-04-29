package com.lld.parkinglot.strategy;

import com.lld.parkinglot.model.VehicleLotRecord;

public interface PricingStrategy {
    Float calculatePrice(VehicleLotRecord record, Float price);
}
