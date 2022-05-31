package com.company.models;

import org.junit.jupiter.api.Test;
import java.util.Date;
import static org.junit.jupiter.api.Assertions.*;

class JournalItemTest {
    private static Driver driver = new Driver("driver");
    private static Car car = new Car(driver, "car");
    private static Date date = new Date();
    private static Boolean isEnter = true;
    private static JournalItem journalItem = new JournalItem(isEnter, car, date);

    @Test
    void getDate() {
        assertEquals(date, journalItem.getDate());
    }

    @Test
    void getEnter() {
        assertEquals(isEnter, journalItem.getEnter());
    }

    @Test
    void getCar() {
        assertEquals(car, journalItem.getCar());
    }
}