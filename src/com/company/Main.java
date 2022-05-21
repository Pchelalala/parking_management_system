package com.company;

import com.company.models.Car;
import com.company.models.CarStation;
import com.company.models.Driver;

import java.util.ArrayList;
import java.util.List;

public class Main {

    public static void main(String[] args) {
        Driver driver = new Driver("Driver1");
        Driver driver1 = new Driver("Driver2");
        List<Car> cars = new ArrayList<>();
        var car = new Car(driver, "Car0");
        cars.add(car);
        cars.add(new Car(driver1, "Car1"));
        cars.add(new Car(driver1, "Car2"));
        cars.add(new Car(driver, "Car3"));
        cars.add(new Car(driver, "Car4"));

        CarStation carStation = new CarStation(cars);

        carStation.createAccount();

        System.out.println(carStation.getAccounts());
        System.out.println(carStation.getJournal());

        carStation.removeCar(car);
        System.out.println(carStation.getJournal());

    }
}