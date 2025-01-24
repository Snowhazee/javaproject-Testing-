package com.lab;

public class EvCar extends Car {
    private double capacity;
    private double efficiency;
    private double chargeLevel;

    public EvCar(String color, double capacity, double efficiency) {
        super(color);
        this.capacity = capacity;
        this.efficiency = efficiency;
        this.chargeLevel = 0;
    }

    @Override
    public void refill() {
        chargeLevel = capacity;
    }

    @Override
    public double getRemainingMileage() {
        return chargeLevel * efficiency;
    }

    @Override
    public double run(double distance) {
        double maxDistance = getRemainingMileage();
        if (distance <= maxDistance) {
            chargeLevel -= distance / efficiency;
            return distance;
        } else {
            chargeLevel = 0;
            return maxDistance;
        }
    }
}
