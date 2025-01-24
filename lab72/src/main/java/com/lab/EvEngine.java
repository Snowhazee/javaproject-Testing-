package com.lab;

public class EvEngine implements Engine {
    private double capacity;     
    private double efficiency;    
    private double batteryLevel;  

    public EvEngine(double capacity, double efficiency) {
        this.capacity = capacity;
        this.efficiency = efficiency;
        this.batteryLevel = 0;
    }

    @Override
    public void refill() {
        batteryLevel = capacity; 
    }

    @Override
    public double getRemainingMileage() {
        return batteryLevel * efficiency; 
    }

    @Override
    public double run(double distance) {
        double remainingMileage = getRemainingMileage();
        if (distance <= remainingMileage) {
            batteryLevel -= distance / efficiency; 
            return distance; 
        } else {
            batteryLevel = 0; 
            return remainingMileage;
        }
    }
}

