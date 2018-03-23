package com.example.cobe.carapp.model;

import java.util.List;

/**
 * Created by cobe on 23/03/2018.
 */

public class Car {

    private int id;
    private String model;
    private String registration;
    private int age;
    private int speed;
    private List<String> images;
    private boolean isFavorite;

    public Car(int id, String model, String registration, int age, int speed, List<String> images, boolean isFavorite) {
        this.id = id;
        this.model = model;
        this.registration = registration;
        this.age = age;
        this.speed = speed;
        this.images = images;
        this.isFavorite = isFavorite;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public String getRegistration() {
        return registration;
    }

    public void setRegistration(String registration) {
        this.registration = registration;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public int getSpeed() {
        return speed;
    }

    public void setSpeed(int speed) {
        this.speed = speed;
    }

    public List<String> getImages() {
        return images;
    }

    public void setImages(List<String> images) {
        this.images = images;
    }

    public boolean isFavorite() {
        return isFavorite;
    }

    public void setFavorite(boolean favorite) {
        isFavorite = favorite;
    }
}
