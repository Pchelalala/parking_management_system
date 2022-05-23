package com.company.models;

public class Driver {
    String name;

    public Driver(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Driver { " +
                " name = " + name + '\'' +
                '}';
    }

    public String getName() {
        return name;
    }
}
