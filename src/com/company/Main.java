package com.company;

import java.sql.SQLException;
import java.text.ParseException;

import com.company.DB.ConnectionFactory;
import com.company.DB.DBUtils;
import com.company.facades.CarStationFacade;

public class Main {
    static {
        try {
            DBUtils.initBD(ConnectionFactory.getConnection());
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
    public static void main(String[] args) throws ParseException, SQLException {
        CarStationFacade carStationFacade = new CarStationFacade();
        carStationFacade.start();
    }
}
