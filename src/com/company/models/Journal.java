package com.company.models;

import java.util.HashMap;
import java.util.Map;

public class Journal {
    Map<Car, JournalItem> carJournalItemMap = new HashMap<>();

    public Journal() {
    }
    public void addItem(Car car, Boolean isEnter){
        carJournalItemMap.put(car, new JournalItem(isEnter));

    }

    public Map<Car, JournalItem> getCarJournalItemMap() {
        return carJournalItemMap;
    }

    public void setCarJournalItemMap(Map<Car, JournalItem> carJournalItemMap) {
        this.carJournalItemMap = carJournalItemMap;
    }

    @Override
    public String toString() {
        return "Journal{" +
                "carJournalItemMap=" + carJournalItemMap +
                '}';
    }
}
