package com.company.utils;

import com.company.models.Car;
import com.company.models.Driver;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;
import static org.junit.jupiter.api.Assertions.*;

class CarUtilsTest {
    static CarUtils carUtils;
    private static List<Driver> drivers;
    @BeforeAll
    public static void init(){
        carUtils = new CarUtils();
        drivers = testDriverProvider();
    }

    public static List<Driver> testDriverProvider() {
        return List.of(
                new Driver("Vasya"),
                new Driver("Petya"),
                new Driver("Kostya"),
                new Driver("Yehor")
        );
    }

    public static Stream<List<Car>> testCarProvider() {
        return Stream.of(
                List.of(
                        new Car(drivers.get(0), "1"),
                        new Car(drivers.get(1), "2")
                )
        );
    }

    @ParameterizedTest
    @MethodSource("testCarProvider")
    void sortCarsByName(List<Car> cars) {
        var sorted = carUtils.sortCarsByName(new ArrayList<>(cars));
        assertEquals(testSortedCarByNameProvider(), sorted);
    }

    public static List<Car> testSortedCarByNameProvider() {
        return List.of(
                new Car(drivers.get(0), "1"),
                new Car(drivers.get(1), "2")
        );
    }

    @ParameterizedTest
    @MethodSource("testCarProvider")
    void sortCarsByDriverName(List<Car> cars) {
        var sorted = carUtils.sortCarsByDriverName(new ArrayList<>(cars));
        assertEquals(testSortedCarByDriverNameProvider(), sorted);
    }

    public static List<Car> testSortedCarByDriverNameProvider() {
        return List.of(
                new Car(drivers.get(1), "2"),
                new Car(drivers.get(0), "1")
        );
    }

    @ParameterizedTest
    @MethodSource("testCarProvider")
    void getAllCarsOnStation(List<Car> cars) {
        var result = carUtils.getAllCarsOnStation(cars);

        assertEquals(testCarOnStationProvider(), result);
    }

    public static List<Car> testCarOnStationProvider() {
        return List.of(
                new Car(drivers.get(0), "1"),
                new Car(drivers.get(1), "2")
        );
    }
}
