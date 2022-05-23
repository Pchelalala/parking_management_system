package com.company.utils;

import com.company.models.Car;
import java.util.Comparator;
import java.util.List;

public class CarUtils {
    public List<Car> sortCarsByName(List<Car> cars){
        cars.sort(Comparator.comparing(Car::getName));
        return cars;
    }

    public List<Car> sortCarsByDriverName(List<Car> cars){
        cars.sort(Comparator.comparing(o -> o.getDriver().getName()));
        return cars;
    }

    public List<Car> getAllCarsOnStation(List<Car> cars){
        return cars.stream().filter(Car::getCarOnStation).toList();
    }
}
