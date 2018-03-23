package com.example.cobe.carapp.common.data;

import com.example.cobe.carapp.model.Car;

import java.util.List;

/**
 * Created by cobe on 23/03/2018.
 */

public class DataHolder {

    private static final DataHolder instance = new DataHolder();

    private DataHolder(){

    }

    public static DataHolder getInstance() {
        return instance;
    }

    private static final List<Car> cars = CreateCars.createCars();

    public List<Car> getCars(){
        return cars;
    }
}
