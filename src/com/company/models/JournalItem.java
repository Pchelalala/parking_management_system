package com.company.models;

import java.util.Date;
import java.util.Objects;

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
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        JournalItem that = (JournalItem) o;
        return Objects.equals(car, that.car) && Objects.equals(date, that.date) && Objects.equals(isEnter, that.isEnter);
    }

    @Override
    public int hashCode() {
        return Objects.hash(car, date, isEnter);
    }

    @Override
    public String toString() {
        return "JournalItem { " +
                " date = " + date +
                "\n isEnter = " + isEnter +
                " }\n";
    }
}
