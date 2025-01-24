package com.lab;

public interface Engine {
    void refill();
    double getRemainingMileage();
    double run(double distance);
}