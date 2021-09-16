package com.example.carrental.dto;

import lombok.Data;

import java.time.LocalDate;

@Data
public class CreateReservationDTO {

    private Integer carId;
    private Long userId;
    private String name;
    private String surname;
    private String email;
    private String location;
    private LocalDate startDate;
    private LocalDate  endDate;


}
