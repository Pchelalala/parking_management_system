package com.company.utils;

import com.company.models.Car;
import com.company.models.Driver;
import com.company.models.JournalItem;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.stream.Stream;
import static org.junit.jupiter.api.Assertions.*;

class JournalUtilsTest {
    static JournalUtils journalUtils;
    private static List<Driver> drivers;
    private static List<Car> cars;
    private static Date date;

    @BeforeAll
    public static void init(){
        journalUtils = new JournalUtils();
        drivers = testDriverProvider();
        cars = testCarProvider();
        date = new Date();
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

    public static Stream<List<JournalItem>> testJournalItemProvider() {
        return Stream.of(
                List.of(
                        new JournalItem(true, cars.get(0), date),
                        new JournalItem(true, cars.get(1), date),
                        new JournalItem(false, cars.get(1), date),
                        new JournalItem(true, cars.get(0), date)
                )
        );
    }

    @ParameterizedTest
    @MethodSource("testJournalItemProvider")
    void sortJournalItemsByCarName(List<JournalItem> journalItems) {
        var result =
                journalUtils.sortJournalItemsByCarName(new ArrayList<>(journalItems));

        assertEquals(new ArrayList<>(getJournalItemsSortedByCarName()), result);
    }

    private List<JournalItem> getJournalItemsSortedByCarName() {
        return List.of(
                new JournalItem(true, cars.get(0), date),
                new JournalItem(true, cars.get(0), date),
                new JournalItem(true, cars.get(1), date),
                new JournalItem(false, cars.get(1), date)
        );
    }

    @ParameterizedTest
    @MethodSource("testJournalItemProvider")
    void sortJournalItemsByDriverName(List<JournalItem> journalItems) {
        var result =
                journalUtils.sortJournalItemsByDriverName(new ArrayList<>(journalItems));

        assertEquals(getJournalItemsSortedByDriverName(), result);

    }

    private List<JournalItem> getJournalItemsSortedByDriverName(){
       return List.of(
               new JournalItem(true, cars.get(1), date),
               new JournalItem(false, cars.get(1), date),
               new JournalItem(true, cars.get(0), date),
                new JournalItem(true, cars.get(0), date)
        );
    }
}
