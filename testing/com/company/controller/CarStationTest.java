package com.company.controller;

import com.company.models.Car;
import com.company.models.Driver;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.stream.Stream;

import static com.sun.org.apache.xerces.internal.util.PropertyState.is;
import static org.junit.jupiter.api.Assertions.*;

class CarStationTest {
    static CarStation carStation;

    @BeforeAll
    public static void init(){
        var cars = testCarProvider();
        carStation = new CarStation(cars);
    }
    public static List<Car> testCarProvider() {
        var drivers = testDriverProvider();

        return List.of(
                new Car(drivers.get(0), "1"),
                new Car(drivers.get(0), "2"),
                new Car(drivers.get(1), "3"),
                new Car(drivers.get(1), "4"),
                new Car(drivers.get(1), "5"),
                new Car(drivers.get(2), "6"),
                new Car(drivers.get(3), "7"),
                new Car(drivers.get(3), "8")

        );
    }
    public static List<Driver> testDriverProvider() {
        return List.of(
                new Driver("Vasya"),
                new Driver("Petya"),
                new Driver("Kostya"),
                new Driver("Yehor")
        );
    }
    @Test
    void calculateAccount() {
        var account = carStation.calculateAccount();

        assertEquals(100 ,account.getBill(account.getBills().get(0).getDriver().getName()).get().getSum());
    }

    @Test
    void getCars() {
        var cars = carStation.getCars();

        assertEquals(testCarProvider(), cars);
    }

    @Test
    void getJournal() {
        var journal = carStation.getJournal();

        assertEquals(carStation.getJournal(), journal);
    }
}