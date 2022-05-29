package com.company.utils;

import com.company.models.Car;
import com.company.models.Driver;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;

class CarUtilsTest {
    static CarUtils carUtils;
    @BeforeAll
    public static void init(){
        carUtils = new CarUtils();
    }
    public static List<Car>  testCarProvider() {
        var drivers = testDriverProvider();

        return List.of(
                new Car(drivers.get(0), "1"),
                new Car(drivers.get(1), "2")
        );
    }

    public static List<Car> testSortedCarByNameProvider() {
        var drivers = testDriverProvider();

        return List.of(
                new Car(drivers.get(0), "1"),
                new Car(drivers.get(1), "2")
             );
    }
    public static List<Car> testSortedCarByDriverNameProvider() {
        var drivers = testDriverProvider();

        return List.of(
                new Car(drivers.get(1), "2"),
                new Car(drivers.get(0), "1")
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
    void sortCarsByName() {
        var cars = testCarProvider();
        var sorted = carUtils.sortCarsByName(new ArrayList<>(cars));
        assertEquals(testSortedCarByNameProvider(), sorted);
    }

    @Test
    void sortCarsByDriverName() {
        var cars = testCarProvider();
        var sorted = carUtils.sortCarsByDriverName(new ArrayList<>(cars));
        assertEquals(testSortedCarByDriverNameProvider(), sorted);
    }

    @Test
    void getAllCarsOnStation() {

    }
}