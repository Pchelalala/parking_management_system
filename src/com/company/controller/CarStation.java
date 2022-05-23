package com.company.controller;

import com.company.models.Account;
import com.company.models.Car;
import java.util.ArrayList;
import java.util.List;

public class CarStation {
    List<Car> cars;
    List<Account> accounts;
    Journal journal;
    int price = 50;

    public CarStation(List<Car> cars) {
        this.cars = new ArrayList<>();
        this.accounts = new ArrayList<>();
        this.journal = new Journal();

        for (var car : cars) {
            addCar(car);
        }
    }
    public Account calculateAccount(){
        var account = new Account(cars, price);
        this.accounts.add(account);

        return account;
    }

    public void addCar(Car car){
        journal.addItem(car, true);
        car.setCarOnStation(true);
        cars.add(car);
    }

    public void removeCar(Car car){
        journal.addItem(car, false);
        car.setCarOnStation(false);
        cars.remove(car);
    }

    public List<Car> getCars() {
        return cars;
    }

    public Journal getJournal() {
        return journal;
    }
}
