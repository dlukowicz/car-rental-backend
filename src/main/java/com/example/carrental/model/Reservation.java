package com.example.carrental.model;

import lombok.Data;

@Data
public class Reservation {

    private int carId;
    private String name;
    private String surname;
    private String email;
    private String location;

}
