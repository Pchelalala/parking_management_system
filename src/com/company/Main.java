package com.company;

import java.text.ParseException;
import com.company.facades.CarStationFacade;

public class Main {
    public static void main(String[] args) throws ParseException {
        CarStationFacade carStationFacade =new CarStationFacade();
        carStationFacade.start();
    }
}
