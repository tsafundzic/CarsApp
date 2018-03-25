package com.example.cobe.carapp.common.data;

import com.example.cobe.carapp.model.Car;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by cobe on 23/03/2018.
 */

public class DataHolder {

    private static final DataHolder instance = new DataHolder();

    private DataHolder() {

    }

    public static DataHolder getInstance() {
        return instance;
    }

    private static final List<Car> cars = CreateCars.createCars();
    private List<Car> carList = new ArrayList<>();

    public List<Car> getCars() {
        return carList;
    }

    public Car returnCarBasedOnCarID(int id) {
        Car returnCar = null;
        for (Car car : cars) {
            if (car.getId() == id) {
                returnCar = car;
            }
        }
        return returnCar;
    }

    public void setFavoritesCarsToList() {
        carList = new ArrayList<>();
        for (Car car : cars) {
            if (car.isFavorite()) {
                carList.add(car);
            }
        }
    }

    public void setAllCarsToList() {
        carList = new ArrayList<>();
        carList = cars;
    }
}
