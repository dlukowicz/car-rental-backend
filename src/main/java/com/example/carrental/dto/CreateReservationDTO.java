package com.example.carrental.dto;

import lombok.Data;

@Data
public class CreateReservationDTO {

    private Integer carId;
    private Long userId;
    private String name;
    private String surname;
    private String email;
    private String location;
    private String startDate;
    private String endDate;


}
