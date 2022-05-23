package com.company.models;

public class Bill {
    Driver driver;
    Integer sum;

    public Bill(Driver driver, Integer sum){
        this.driver = driver;
        this.sum = sum;
    }

    public void addSum(Integer sum){
        this.sum += sum;
    }

    @Override
    public String toString() {
        return "Bill{" +
                "driver=" + driver +
                ", sum=" + sum +
                '}';
    }
}
