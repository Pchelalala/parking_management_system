package com.company.models;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class CarTest {
    private static Driver driver = new Driver("driver");
    private static Car car = new Car(driver, "car");

    @Test
    void getDriver() {
        assertEquals(driver, car.getDriver());
    }

    @Test
    void getName() {
        assertEquals(driver, car.getName());
    }

    @Test
    void getCarOnStation() {
        assertEquals(true, car.getCarOnStation());
    }
}