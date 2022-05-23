package com.company.utils;

import com.company.models.Car;
import com.company.models.JournalItem;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class JournalUtils {
    public List<JournalItem> sortJournalItemsByCarName(List<JournalItem> journalItems){
        journalItems.sort(Comparator.comparing(o -> o.getCar().getName()));
        return journalItems;
    }

    public List<JournalItem> sortJournalItemsByDriverName(List<JournalItem> journalItems){
        journalItems.sort(Comparator.comparing(journalItem -> journalItem.getCar().getDriver().getName()));
        return journalItems;
    }

    public List<Car> getAllCarsOnStation(List<Car> cars){
        return cars.stream().filter(Car::getCarOnStation).toList();
    }
}
