package com.company.controller;

import com.company.models.Car;
import com.company.models.Driver;
import com.company.models.JournalItem;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import java.util.Date;
import java.util.List;
import static org.junit.Assert.assertEquals;

class JournalTest {
    private static Journal journal;
    private static List<Driver> drivers;
    private static List<Car> cars;
    private static Date date;

    @BeforeAll
    public static void init(){
        drivers = testDriverProvider();
        cars = testCarProvider();
        date = new Date();
        journal = new Journal();
        journal.journalItems.addAll(testJournalItemProvider());

    }

    public static List<Driver> testDriverProvider() {
        return List.of(
                new Driver("Vasya"),
                new Driver("Petya"),
                new Driver("Kostya"),
                new Driver("Yehor")
        );
    }

    public static List<Car> testCarProvider() {
        return List.of(
                new Car(drivers.get(0), "1"),
                new Car(drivers.get(1), "2")
        );
    }

    public static List<JournalItem> testJournalItemProvider() {
        return List.of(
                        new JournalItem(true, cars.get(0), date),
                        new JournalItem(true, cars.get(1), date),
                        new JournalItem(false, cars.get(1), date),
                        new JournalItem(true, cars.get(0), date)
                );
    }

    @Test
    void getCarInfo() {
        assertEquals(testGetCarInfoProvider(), journal.getCarInfo(cars.get(0).getName()));
    }
    public static List<JournalItem> testGetCarInfoProvider() {
        return List.of(
                new JournalItem(true, cars.get(0), date),
                new JournalItem(true, cars.get(0), date)
        );
    }

    @Test
    void getDriverInfo() {
        assertEquals(testGetDriverInfoProvider(), journal.getDriverInfo(drivers.get(0).getName()));
    }
    public static List<JournalItem> testGetDriverInfoProvider() {
        return List.of(
                new JournalItem(true, cars.get(0), date),
                new JournalItem(true, cars.get(0), date)
        );
    }

    @Test
    void getJournalItemsByDate() {
        assertEquals(testGetJournalItemsByDateProvider(), journal.getJournalItemsByDate(new Date()));
    }

    public static List<JournalItem> testGetJournalItemsByDateProvider() {
        return List.of(
                new JournalItem(true, cars.get(0), date),
                new JournalItem(true, cars.get(1), date),
                new JournalItem(false, cars.get(1), date),
                new JournalItem(true, cars.get(0), date)
        );
    }
}
