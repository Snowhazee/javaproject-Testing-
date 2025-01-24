package org.test;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

import com.lab.*;

class ClassTest {
    @Test public void
    all_engines_can_be_instantiated() {
        Car petrolCar = new Car("Red", new PetrolEngine(50, 15)); // 50L, 15 km/L
        Car dieselCar = new Car("Blue", new DieselEngine(60, 20)); // 60L, 20 km/L
        Car evCar = new Car("Green", new EvEngine(80, 6)); // 80 kWh, 6 km/kWh

        assertNotNull(petrolCar);
        assertNotNull(dieselCar);
        assertNotNull(evCar);
    }

    @Test public void
    newly_created_engines_have_no_mileage() {
        Car petrolCar = new Car("Red", new PetrolEngine(50, 15));
        Car dieselCar = new Car("Blue", new DieselEngine(60, 20));
        Car evCar = new Car("Green", new EvEngine(80, 6));

        assertEquals(0, petrolCar.getRemainingMileage());
        assertEquals(0, dieselCar.getRemainingMileage());
        assertEquals(0, evCar.getRemainingMileage());
    }

    @Test public void
    cars_cannot_run_farther_than_its_remaining_mileage() {
        Car petrolCar = new Car("Red", new PetrolEngine(50, 15)); // 50L, 15 km/L
        petrolCar.refill();
        double mileage = petrolCar.getRemainingMileage();

        assertEquals(mileage, petrolCar.run(mileage + 10)); // Attempt to run beyond mileage
        assertEquals(0, petrolCar.getRemainingMileage());
    }

    @Test public void
    efficiency_and_mileage_calculations_agree() {
        Car evCar = new Car("Green", new EvEngine(80, 6)); // 80 kWh, 6 km/kWh
        evCar.refill();

        assertEquals(80 * 6, evCar.getRemainingMileage());
    }

    @Test public void
    running_twice_reduces_energy_accordingly() {
        Car dieselCar = new Car("Blue", new DieselEngine(60, 20)); // 60L, 20 km/L
        dieselCar.refill();

        dieselCar.run(200); // Run 200 km
        double mileageAfterFirstRun = dieselCar.getRemainingMileage();

        dieselCar.run(200); // Run another 200 km
        double mileageAfterSecondRun = dieselCar.getRemainingMileage();

        assertEquals(60 * 20 - 200, mileageAfterFirstRun);
        assertEquals(60 * 20 - 400, mileageAfterSecondRun);
    }

    @Test public void
    color_is_stored_and_engine_methods_are_correctly_delegated() {
        PetrolEngine petrolEngine = new PetrolEngine(50, 15); // 50L, 15 km/L
        Car petrolCar = new Car("Red", petrolEngine);

        assertEquals("Red", petrolCar.getColor());

        petrolCar.refill();
        double engineMileage = petrolEngine.getRemainingMileage();
        double carMileage = petrolCar.getRemainingMileage();

        assertEquals(engineMileage, carMileage);

        double distanceRun = petrolCar.run(100); // Run 100 km
        assertEquals(100, distanceRun);

        assertEquals(petrolEngine.getRemainingMileage(), petrolCar.getRemainingMileage());
    }

    @Test public void
    cars_cannot_run_before_refill() {
        Car evCar = new Car("Green", new EvEngine(80, 6)); // 80 kWh, 6 km/kWh

        // Before refill
        assertEquals(0, evCar.run(100)); // Should not run at all

        // After refill
        evCar.refill();
        assertEquals(100, evCar.run(100)); // Should run 100 km
        assertEquals(80 * 6 - 100, evCar.getRemainingMileage());
    }
}
