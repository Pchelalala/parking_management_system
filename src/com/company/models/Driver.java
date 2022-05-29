package com.company.models;

import java.util.Objects;

public class Driver {
    String name;

    public Driver(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Driver { name = " + name +
                " }\n";
    }

    public String getName() {
        return name;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Driver)) return false;
        Driver driver = (Driver) o;
        return Objects.equals(name, driver.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name);
    }
}
