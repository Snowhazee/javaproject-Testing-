package com.lab;

public  class Car {
    private String color;
    private Engine engine;
    public Car(String color, Engine engine) {
        this.color = color;
        this.engine = engine;
    }

    public String getColor() {
        return color;
    }

    public void refill(){
       engine.refill();
    }

    public  double getRemainingMileage(){
        return engine.getRemainingMileage();
    }

    public  double run(double distance){
       return engine.run(distance);
    }
}