package com.lab;

public abstract class Car {
    private String color;

    public Car(String color) {
        this.color = color;
    }

    public String getColor() {
        return color;
    }

    public abstract void refill();

    public abstract double getRemainingMileage();

    public abstract double run(double distance);
}