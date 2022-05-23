package com.company.controller;

import com.company.models.Car;
import com.company.models.JournalItem;
import java.util.*;

public class Journal {
    List<JournalItem> journalItems = new ArrayList<>();

    public void addItem(Car car, Boolean isEnter){
        journalItems.add(new JournalItem(isEnter, car));
    }

    public List<JournalItem> getCarInfo(String carName){
        return journalItems.stream()
                .filter(journalItem ->
                        journalItem.getCar().getName().equals(carName))
                .toList();
    }

    public List<JournalItem> getDriverInfo(String driverName){
        return journalItems.stream()
                .filter(journalItem ->
                        journalItem.getCar().getDriver().getName().equals(driverName))
                .toList();
    }

    public List<JournalItem> getJournalItemsByDate(Date end){
        return journalItems.stream()
                .filter(journalItem ->
                        journalItem.getDate().compareTo(end) < 0)
                .toList();
    }

    @Override
    public String toString() {
        return "Journal { " +
                " journalItems = " + journalItems +
                " }\n";
    }
}
