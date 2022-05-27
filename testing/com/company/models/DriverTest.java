package com.company.models;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class DriverTest {

    @Test
    void getName() {
        var driver = new Driver("SomeDriver");

        assertEquals("SomeDriver", driver.getName());
        assertNotEquals("someDriver", driver.getName());
    }
}