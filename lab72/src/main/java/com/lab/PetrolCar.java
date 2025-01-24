package com.lab;

public class PetrolCar extends Car {
    private double capacity;
    private double efficiency;
    private double fuelLevel;

    public PetrolCar(String color, double capacity, double efficiency) {
        super(color);
        this.capacity = capacity;
        this.efficiency = efficiency;
        this.fuelLevel = 0;
    }

    @Override
    public void refill() {
        fuelLevel = capacity;
    }

    @Override
    public double getRemainingMileage() {
        return fuelLevel * efficiency;
    }

    @Override
    public double run(double distance) {
        double maxDistance = getRemainingMileage();
        if (distance <= maxDistance) {
            fuelLevel -= distance / efficiency;
            return distance;
        } else {
            fuelLevel = 0;
            return maxDistance;
        }
    }
}
