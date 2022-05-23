package com.company.data;

import com.company.models.Car;
import com.company.models.Driver;

import java.util.ArrayList;
import java.util.List;

public class StaticDataSource {

    public static List<Car> cars = new ArrayList<>();
    public static List<Driver> drivers = new ArrayList<>();
    static{
        addDriverToDataSource("Driver1");
        addDriverToDataSource("Driver2");
        addDriverToDataSource("Driver3");

        addCarToDataSource("1", drivers.get(0));
        addCarToDataSource("2", drivers.get(0));
        addCarToDataSource("3", drivers.get(0));
        addCarToDataSource("4", drivers.get(1));
        addCarToDataSource("5", drivers.get(1));
        addCarToDataSource("6", drivers.get(2));
    }

    public static void addDriverToDataSource(String name){
        drivers.add(new Driver(name));
    }

    public static void addCarToDataSource(String name, Driver driver){
        cars.add(new Car(driver, name));
    }
}
