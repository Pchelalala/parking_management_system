package com.company.models;

import java.util.ArrayList;
import java.util.List;

public class Account {
    List<Bill> bills = new ArrayList<>();

    public Account(List<Car> cars, Integer price){
        setBills(cars, price);
    }
    private void setBills(List<Car> cars, Integer price){
        var index = 0;
        for (var item : cars) {
            var fondedBills = bills.stream().filter(billItem -> billItem.driver == item.driver).toList();
            if(!fondedBills.isEmpty()){
                fondedBills.stream().findFirst().get().addSum(price);
            }
            else {
                bills.add(new Bill(item.driver, price));
            }
            index++;
        }
    }

    @Override
    public String toString() {
        return "Account{" +
                "bills=" + bills +
                '}';
    }
}
