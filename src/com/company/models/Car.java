package com.company.models;

public class Car {
    Driver driver;
    String name;
    Boolean isCarOnStation;

    public Car(Driver driver, String name) {
        this.driver = driver;
        this.name = name;
    }

    public Driver getDriver() {
        return driver;
    }

    public void setDriver(Driver driver) {
        this.driver = driver;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Boolean getCarOnStation() {
        return isCarOnStation;
    }

    public void setCarOnStation(Boolean carOnStation) {
        isCarOnStation = carOnStation;
    }

    @Override
    public String toString() {
        return "Car { " +
                " driver = " + driver +
                " car name = " + name +
                " isCarOnStation = " + isCarOnStation +
                " }\n";
    }
}
