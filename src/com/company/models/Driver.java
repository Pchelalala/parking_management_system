package com.company.models;

import java.util.Objects;

public class Driver {
    Integer id;
    String name;

    public Driver(){}
    public Driver(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Driver { name = " + name +
                " }\n";
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
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
