package com.example.carrental.model;

import lombok.Data;

@Data
public class Car {

    private int id;
    private String name;
    private String fuel;
    private int year;
    private String description;
    private float mileage;
    private String imgsrc;

    //TODO remove
    public Car(int id, String name, String fuel, int year, String description,
               float mileage, String imgsrc) {
        this.id = id;
        this.name = name;
        this.fuel = fuel;
        this.year = year;
        this.description = description;
        this.mileage = mileage;
        this.imgsrc = imgsrc;
    }


    public Car() {

    }
}
