# Assignment 7-2: Cars and Engines

Name:

ID:

## Problem Overview

**Problem Statement:**

Restructure the given code from an inheritance-based design to a composition-based design. The original code includes a `Car` class hierarchy with the abstract class `Car` and its concrete subclasses `PetrolCar`, `DieselCar`, and `EvCar`. Additionally, there is a main `App` class that instantiates various car objects. Your task is to replace the inheritance structure with a design that uses composition, separating the functionality of the car and its engine.

**In the new design:**

- A `Car` object will include an `Engine` object as a component.
- `Engine` will be implemented as an interface, with concrete implementations for `PetrolEngine`, `DieselEngine`, and `EvEngine`.

The focus of this assignment is to understand and apply the principles of composition to design a flexible and reusable codebase.

## Setup and Environment

- **WARNING:** Do not modify the `.github` or `gradle-tests` directories. These directories are essential for the automated grading process, and any changes may result in incorrect grading.

The Maven project has already been created for you. The package name is `com.lab`, and the project name (and directory) is `lab72`. Use `mvn compile` to build the project and `java -cp target/classes com.lab.App` or `mvn exec:java "-Dexec.mainClass=com.lab.App"` to run it.

## Requirements and Specifications

### Instructions

Refactor the given code into a composition-based design. Ensure the design adheres to the principle of composition rather than inheritance. There will still be inheritance in the `Engine` class hierarchy based on the `Engine` interface, but the `Car` class itself should be free of inheritance.

### Class/Method Specifications

- `Car` class:
  - Constructor: `Car(String color, Engine engine)`
  - Method:
    - `String getColor()`: Returns the color of the car.
  - The `Car` class represents the vehicle itself and delegates engine-related functionality to its Engine component.
  - For convenience, the `Car` class also contains these methods that mirror `Engine` functionality:
    - `void refill()`: Delegates to the engine's `refill()` method.
    - `double getRemainingMileage()`: Delegates to the engine's `getRemainingMileage()` method.
    - `double run(double distance)`: Delegates to the engine's `run(double distance)` method.
- `Engine` interface:
  - Methods:
    - `void refill()`: Fully refill the car with fuel or charge.
    - `double getRemainingMileage()`: Returns the number of kilometers the car can travel with the current energy level.
    - `double run(double distance)`: Simulates running the car for a specified distance and returns the actual distance traveled (consider cases where the car might run out of energy).
- Concrete engine implementations:
  - `PetrolEngine`: Represents an engine that runs on petrol (gasoline/benzine).
  - `DieselEngine`: Represents an engine that runs on diesel fuel.
  - `EvEngine`: Represents an engine that runs on electricity.
  - Each engine has:
    - A constructor that takes its energy capacity and efficiency as parameters:
      - The constructor should be in the form of: `PetrolEngine(double capacity, double efficiency)`
      - `capacity` is the maximum energy capacity of the specific `Engine` (*liters* for fuel-based engines and *kWh* for EV engines).
      - `efficiency` is the number of kilometers the engine can travel using 1 unit of energy (*km/L* for fuel-based engines and *km/kWh* for EV engines).
    - The energy tank starts empty and must be refilled before the car can travel.

## Examples and Usage

Executing `main()` should produce the following output:

```
PetrolCar color: Red
PetrolCar remaining mileage: 750.0
PetrolCar ran: 100.0 km
DieselCar color: Blue
DieselCar remaining mileage: 1200.0
DieselCar ran: 150.0 km
EvCar color: Green
EvCar remaining mileage: 480.0
EvCar ran: 480.0 km
```

## Additional Notes

**Hints:**

- Consider using instance variables in the `Engine` implementations to track the current energy level.
- When designing the `run()` method, account for edge cases like attempting to drive farther than the remaining mileage.

**Common Pitfalls:**

- Avoid coupling the `Car` class to specific engine types. Use the `Engine` interface for flexibility.
- Ensure that all energy-related operations are encapsulated within the engine classes, keeping the `Car` class focused on vehicle-related functionality.
