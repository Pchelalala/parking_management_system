package com.company.controller;

import com.company.DB.CarJDBCDao;
import com.company.DB.DriverJDBCDao;
import com.company.models.Account;
import com.company.models.Car;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class CarStation {
    List<Account> accounts;
    Journal journal;
    int price = 50;

    DriverJDBCDao driverJDBCDao;
    CarJDBCDao carJDBCDao;

    public CarStation(List<Car> cars) throws SQLException {
        this.accounts = new ArrayList<>();
        this.journal = new Journal();
        driverJDBCDao = new DriverJDBCDao();
        carJDBCDao = new CarJDBCDao();
        for (var car : cars) {
            addCar(car);
        }
    }
    public Account calculateAccount(){
        var account = new Account(getCars(), price);
        this.accounts.add(account);

        return account;
    }

    public void addCar(Car car){
        journal.addItem(car, true);
        car.setCarOnStation(true);

        carJDBCDao.insert(car);
    }

    public void removeCar(Car car){
        journal.addItem(car, false);
        car.setCarOnStation(false);

        carJDBCDao.delete(car);

    }

    public List<Car> getCars() {
        return carJDBCDao.getAll();
    }

    public Journal getJournal() {
        return journal;
    }
}
