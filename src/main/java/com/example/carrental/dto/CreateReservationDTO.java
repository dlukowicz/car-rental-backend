package com.example.carrental.dto;

import lombok.Data;

@Data
public class CreateReservationDTO {

    //TODO przekazc uzytwkonika ktory zarezerwowal

    private int carId;
    private String name;
    private String surname;
    private String email;
    private String location;
    private String startDate;
    private String endDate;


}
