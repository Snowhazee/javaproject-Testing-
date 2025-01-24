package com.lab;

public class App {
    public static void main(String[] args) {
        // // Instantiation for the inheritance-based design
        // Car petrolCar = new PetrolCar("Red", 50, 15); // 50L, 15 km/L
        // Car dieselCar = new DieselCar("Blue", 60, 20); // 60L, 20 km/L
        // Car evCar = new EvCar("Green", 80, 6); // 80 kWh, 6 km/kWh

        // Instantiation for the composition-based design
        Car petrolCar = new Car("Red", new PetrolEngine(50, 15)); // 50L, 15 km/L
        Car dieselCar = new Car("Blue", new DieselEngine(60, 20)); // 60L, 20 km/L
        Car evCar = new Car("Green", new EvEngine(80, 6)); // 80 kWh, 6 km/kWh

        petrolCar.refill();
        System.out.println("PetrolCar color: " + petrolCar.getColor());
        System.out.println("PetrolCar remaining mileage: " + petrolCar.getRemainingMileage());
        System.out.println("PetrolCar ran: " + petrolCar.run(100) + " km");

        dieselCar.refill();
        System.out.println("DieselCar color: " + dieselCar.getColor());
        System.out.println("DieselCar remaining mileage: " + dieselCar.getRemainingMileage());
        System.out.println("DieselCar ran: " + dieselCar.run(150) + " km");

        evCar.refill();
        System.out.println("EvCar color: " + evCar.getColor());
        System.out.println("EvCar remaining mileage: " + evCar.getRemainingMileage());
        System.out.println("EvCar ran: " + evCar.run(500) + " km");
    }
}
