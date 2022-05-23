package com.company.models;

import java.util.Date;

public class JournalItem {
    Car car;
    Date date;
    Boolean isEnter;

    public JournalItem(Boolean isEnter, Car car) {
        this.car = car;
        this.date = new Date();
        this.isEnter = isEnter;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public Boolean getEnter() {
        return isEnter;
    }

    public void setEnter(Boolean enter) {
        isEnter = enter;
    }

    public Car getCar() {
        return car;
    }

    public void setCar(Car car) {
        this.car = car;
    }

    @Override
    public String toString() {
        return "JournalItem{" +
                "date=" + date +
                ", isEnter=" + isEnter +
                '}';
    }
}
