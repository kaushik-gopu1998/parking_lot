package com.lld.parkinglot.strategy;

import com.lld.parkinglot.model.VehicleLotRecord;

import java.time.Duration;

public class DurationPricingStrategy implements PricingStrategy{
    @Override
    public Float calculatePrice(VehicleLotRecord record, Float price) {
        Long startTime = record.getEntryTime();
        Long endTime = record.getExitTime();
        Long duration = endTime-startTime;
        Long hours = duration/36_00_000;
        return hours*price;
    }
}
