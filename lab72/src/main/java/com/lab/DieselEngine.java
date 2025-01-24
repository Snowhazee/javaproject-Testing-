package com.lab;

public class DieselEngine implements Engine {
    private double capacity;      
    private double efficiency;    
    private double fuelLevel;     

    public DieselEngine(double capacity, double efficiency) {
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
        double remainingMileage = getRemainingMileage();
        if (distance <= remainingMileage) {
            fuelLevel -= distance / efficiency; 
            return distance; 
        } else {
            fuelLevel = 0; 
            return remainingMileage;
        }
    }
}
