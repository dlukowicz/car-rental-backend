package com.example.carrental.dto;

import lombok.Data;

@Data
public class CreateReservationDTO {

    private int carId;
    private String name;
    private String surname;
    private String email;
    private String location;
    private String startDate;
    private String endDate;
    // dateStart
    // dateEnd


}
