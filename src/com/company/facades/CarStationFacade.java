package com.company.facades;

import com.company.ConsoleOutputStrategy;
import com.company.controller.CarStation;
import com.company.data.StaticDataSource;
import com.company.models.Car;
import com.company.models.Driver;
import com.company.models.JournalItem;
import com.company.utils.CarUtils;
import com.company.utils.InputUtils;
import com.company.utils.JournalUtils;

import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;

public class CarStationFacade {
    static boolean isUserIn = true;
    ConsoleOutputStrategy consoleOutputStrategy;
    JournalUtils journalUtils;
    InputUtils inputUtils;
    CarStation carStation;

    public CarStationFacade() {
        consoleOutputStrategy = new ConsoleOutputStrategy();
        inputUtils = new InputUtils();
        carStation = new CarStation(StaticDataSource.cars);
        journalUtils = new JournalUtils();
    }

    public void start() throws ParseException {
        while (isUserIn) {
            update();
        }
    }

    private void update() throws ParseException {
        consoleOutputStrategy.updateMessage();
        Integer selected = inputUtils.readInt();
        runFunctionality(selected);
    }

    public void runFunctionality(Integer selectedFunction) throws ParseException {
        switch (selectedFunction) {
            case 1 -> task1();
            case 2 -> task2();
            case 3 -> task3();
            case 4 -> task4();
            case 5 -> task5();
            case 6 -> task6();
            case 7 -> task7();
            case 8 -> task8();
            case 9 -> task9();
        }
    }

    public void task1() {
        var result = carStation.getCars();
        consoleOutputStrategy.showTask1Result(result);
    }

    public void task2() throws ParseException {
        consoleOutputStrategy.showTask2Requirements();

        var endDate = inputUtils.readDate();
        var result = carStation.getJournal().getJournalItemsByDate(endDate);
        consoleOutputStrategy.showSortingInfo();
        var choice = inputUtils.readInt();

        List<JournalItem> journalItems = new ArrayList<>(result);

        if(choice == 1){
            journalUtils.sortJournalItemsByCarName(journalItems);
        }
        else if (choice == 2){
            journalUtils.sortJournalItemsByDriverName(journalItems);
        }
        consoleOutputStrategy.showTask2Result(journalItems);
    }

    public void task3() {
        consoleOutputStrategy.showTask3Requirements();

        var carName = inputUtils.readString();
        var result = carStation.getJournal().getCarInfo(carName);

        consoleOutputStrategy.showTask3Result(result);
    }

    public void task4() {
        consoleOutputStrategy.showTask4Requirements();

        var driverName = inputUtils.readString();
        var result = carStation.getJournal().getDriverInfo(driverName);

        consoleOutputStrategy.showTask4Result(result);
    }

    public void task5() {
        isUserIn = false;
    }

    public void task6() {
        consoleOutputStrategy.showTask6Requirements();

        var driverName = inputUtils.readString();

        StaticDataSource.drivers.add(new Driver(driverName));
    }

    public void task7() {
        consoleOutputStrategy.showTask7Requirements();

        var carName = inputUtils.readString();

        consoleOutputStrategy.showDrivers(StaticDataSource.drivers);

        var driverName = inputUtils.readString();
        var driver =  StaticDataSource.drivers.stream().filter(item -> item.getName().equals(driverName)).findFirst();

        driver.ifPresent(value -> carStation.addCar(new Car(value, carName)));

    }

    public void task8() {
        consoleOutputStrategy.showTask8Requirements();

        var carName = inputUtils.readString();
        var car =  carStation.getCars().stream().filter(item -> item.getName().equals(carName)).findFirst();

        car.ifPresent(value -> carStation.removeCar(value));
    }

    public void task9() {
        consoleOutputStrategy.showTask9Requirements();

        var driverName = inputUtils.readString();
        var account = carStation.calculateAccount();
        var result = account.getBill(driverName);

        consoleOutputStrategy.showTask9Result(result);
    }
}
