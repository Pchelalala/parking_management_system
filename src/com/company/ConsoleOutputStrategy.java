package com.company;

import java.util.List;
import java.util.Optional;
import com.company.models.Bill;
import com.company.models.Car;
import com.company.models.Driver;
import com.company.models.JournalItem;

public class ConsoleOutputStrategy {
    public void updateMessage(){
        showFunctionality();
        System.out.println("\nEnter the task:");
    }

    public void showFunctionality(){
        showFunctionalityItem(1, "show all cars");
        showFunctionalityItem(2, "get journal by date");
        showFunctionalityItem(3, "get info of car");
        showFunctionalityItem(4, "get info of driver");
        showFunctionalityItem(5, "exit");
        showFunctionalityItem(6, "add driver");
        showFunctionalityItem(7, "add car");
        showFunctionalityItem(8, "remove car");
        showFunctionalityItem(9, "calculate bills by driver");
    }

    public void showFunctionalityItem(Integer number, String description){
        System.out.println(number + Constants.SHOW_FUNCTIONALITY_ITEM_SEPARATOR + description);
    }

    public void showTask1Result(List<Car> cars) {
        if (cars.isEmpty()) {
            System.out.println("No cars");
            return;
        }
        System.out.println(cars);
    }

    public void showTask2Result(List<JournalItem> journalItems){
        if (journalItems.isEmpty()) {
            System.out.println("No journal items before that date");
            return;
        }
        System.out.println(journalItems);
    }

    public void showTask3Result(List<JournalItem> journalItems){
        if(journalItems.isEmpty()){
            System.out.println("No such car");
            return;
        }
        System.out.println(journalItems);
    }

    public void showTask4Result(List<JournalItem> journalItems){
        if(journalItems.isEmpty()){
            System.out.println("No such driver");
            return;
        }
        System.out.println(journalItems);
    }

    public void showTask9Result(Optional<Bill> bill){
        if(bill.isEmpty()){
            System.out.println("No such driver");
            return;
        }
        System.out.println(bill.get());
    }

    public void showTask2Requirements(){
        System.out.println("\nEnter date in " + Constants.DATE_FORMAT + " format:");
    }

    public void showTask3Requirements(){
        System.out.println("\nEnter car name:");
    }

    public void showTask4Requirements(){
        System.out.println("\nEnter driver name in:");
    }

    public void showTask6Requirements(){
        System.out.println("\nEnter driver name to add:");
    }

    public void showTask7Requirements(){
        System.out.println("\nEnter car name and choose driver:");
    }

    public void showTask8Requirements(){
        System.out.println("\nEnter car name to remove:");
    }

    public void showTask9Requirements(){
        System.out.println("\nEnter driver name :");
    }

    public void showSortingInfo(){
        System.out.println("\nWanna sort in car name(1) or driver name(2)? :");
    }

    public void showDrivers(List<Driver> drivers){
        System.out.println(drivers);
    }
}
