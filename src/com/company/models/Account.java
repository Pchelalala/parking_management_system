package com.company.models;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class Account {
    List<Bill> bills = new ArrayList<>();

    public Account(List<Car> cars, Integer price){
        setBills(cars, price);
    }

    public List<Bill> getBills() {
        return bills;
    }

    public void setBills(List<Bill> bills) {
        this.bills = bills;
    }

    private void setBills(List<Car> cars, Integer price){
        for (var item : cars) {
            var fondedBills = bills.stream().filter(billItem -> billItem.driver == item.driver).toList();
            if(!fondedBills.isEmpty()){
                fondedBills.stream().findFirst().get().addSum(price);
            }
            else {
                bills.add(new Bill(item.driver, price));
            }
        }
    }

    public Optional<Bill> getBill(String driverName){
        return bills.stream().filter(bill -> bill.driver.getName().equals(driverName)).findFirst();
    }

    @Override
    public String toString() {
        return "Account { " +
                " bills = " + bills +
                " }\n";
    }
}
