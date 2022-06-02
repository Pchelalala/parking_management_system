package com.company.DB;

import com.company.models.Driver;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class DriverJDBCDao implements IDao<Driver> {
    Connection connection;
    Statement statement;

    public DriverJDBCDao() throws SQLException {
        connection = ConnectionFactory.getConnection();
        statement = connection.createStatement();
    }

    @Override
    public Optional<Driver> get(int id) {
        Optional<Driver> result = Optional.empty();
        try {
            Statement statement = connection.createStatement();
            ResultSet rs = statement.executeQuery("SELECT * FROM [driver] WHERE id=" + id);

            if (rs.next()) {
                result = DBUtils.getDriver(rs);
                if(result.isEmpty()){
                    return Optional.empty();
                }
            }
            DBUtils.close(rs);
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return result;
    }

    @Override
    public List<Driver> getAll() {
        List<Driver> drivers = new ArrayList<>();
        try {
            Statement statement = connection.createStatement();
            ResultSet rs = statement.executeQuery("SELECT * FROM [driver]");

            while (rs.next()) {
                drivers.add(DBUtils.getDriver(rs).get());
            }

            DBUtils.close(rs);
        }
        catch (SQLException ex) {
            ex.printStackTrace();
        }
        return drivers;
    }

    @Override
    public boolean insert(Driver driver) {
        boolean result = false;
        try {
            Statement statement = connection.createStatement();
            result = statement.execute(
                    "INSERT INTO Driver(name) " +
                            "VALUES('" + driver.getName() + "');");
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        System.out.println("Animal inserted");
        return result;
    }

    @Override
    public boolean update(Driver driver) {
        boolean result = false;
        try {
            Statement statement = connection.createStatement();
            result = statement.execute(
                    "UPDATE Driver" +
                            "SET Name = '" + driver.getName() + "'" +
                            "WHERE id = " + driver.getId() + ";");
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return result;
    }

    @Override
    public boolean delete(Driver driver) {
        boolean result = false;
        try {
            result = statement.execute(
                    "DELETE FROM Driver WHERE id=" + driver.getId());
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        System.out.println("Driver deleted");
        return result;
    }

    @Override
    public boolean clearData() {
        boolean result = false;
        try {
            result = statement.execute(
                    "DELETE FROM Driver");
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return result;
    }
}
