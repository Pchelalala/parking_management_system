package com.company.models;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class AccountTest {

    static Account account;
    public static void init(){
        account = new Account(testCarProvider(), 50);
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
    void getBill() {
        var bills = account.getBills();
        assertEquals(account.getBills(), bills);

    }
}