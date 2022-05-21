package com.company.models;

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

    public void addCar(Car car){
        journal.addItem(car, true);
        car.isCarOnStation = true;
        cars.add(car);
    }

    public void removeCar(Car car){
        journal.addItem(car, false);
        car.isCarOnStation = false;
        cars.remove(car);
    }

    public void createAccount(){
        accounts.add(new Account(cars, price));
    }

    public List<Car> getCars() {
        return cars;
    }

    public void setCars(List<Car> cars) {
        this.cars = cars;
    }

    public List<Account> getAccounts() {
        return accounts;
    }

    public void setAccounts(List<Account> accounts) {
        this.accounts = accounts;
    }

    public Journal getJournal() {
        return journal;
    }

    public void setJournal(Journal journal) {
        this.journal = journal;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }
}
