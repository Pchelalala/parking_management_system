package com.company.models;

import java.util.Objects;

public class Car {
    Driver driver;
    String name;
    Boolean isCarOnStation;
    public Car(Driver driver, String name) {
        this.driver = driver;
        this.name = name;
        isCarOnStation = true;
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
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Car)) return false;
        Car car = (Car) o;
        return Objects.equals(driver, car.driver) && Objects.equals(name, car.name) && Objects.equals(isCarOnStation, car.isCarOnStation);
    }

    @Override
    public int hashCode() {
        return Objects.hash(driver, name, isCarOnStation);
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
