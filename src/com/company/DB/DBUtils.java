package com.company.DB;

import com.company.models.Car;
import com.company.models.Driver;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Optional;

public class DBUtils {
    public static void close(Connection connection){
        if(connection == null) return;
        try {
            connection.close();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    public static void close(ResultSet resultSet){
        if(resultSet == null) return;
        try {
            resultSet.close();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    public static void initBD(Connection connection) throws SQLException {
        connection = ConnectionFactory.getConnection();

        dropDBTable(connection);

        Statement stmt = connection.createStatement();

        executeQuery(stmt,
                "CREATE TABLE IF NOT EXISTS Driver (" +
                            "id INTEGER PRIMARY KEY AUTOINCREMENT, " +
                            "name TEXT NOT NULL" +
                        ")");

        executeQuery(stmt,
                "CREATE TABLE IF NOT EXISTS Car (" +
                            "id INTEGER PRIMARY KEY AUTOINCREMENT, " +
                            "name TEXT NOT NULL," +
                            "driverId INTEGER NOT NULL," +
                            "carOnStation BOOLEAN NOT NULL" +
                        ")");
        stmt.close();
    }

    public static void dropDBTable(Connection connection) throws SQLException {
        Statement  stmt = connection.createStatement();
        executeQuery(stmt,
                "drop table if exists Driver;drop table if exists Car;");
    }

    public static void executeQuery(Statement stmt, String query) throws SQLException {
        stmt.executeUpdate(query);
    }

    public static Optional<Driver> getDriver(ResultSet rs) throws SQLException {

        var driver = new Driver();

        driver.setId(rs.getInt("id"));
        driver.setName(rs.getString("name"));

        return Optional.of(driver);
    }

    public static Optional<Car> getCar(ResultSet rs) throws SQLException {

        var car = new Car();

        var driver = getDriver(rs);
        car.setId(rs.getInt("id"));
        car.setName(rs.getString("name"));
        driver.ifPresent(car::setDriver);
        car.setCarOnStation(rs.getBoolean("name"));

        return Optional.of(car);
    }
}
