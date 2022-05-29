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

    public Driver getDriver() {
        return driver;
    }

    public void setDriver(Driver driver) {
        this.driver = driver;
    }

    public Integer getSum() {
        return sum;
    }

    public void setSum(Integer sum) {
        this.sum = sum;
    }

    @Override
    public String toString() {
        return "Bill { " +
                " driver = " + driver +
                " sum = " + sum +
                " }\n";
    }
}
