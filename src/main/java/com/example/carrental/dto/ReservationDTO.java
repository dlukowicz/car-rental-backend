package com.example.carrental.dto;

import com.example.carrental.model.Car;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ReservationDTO {
    private Integer reservationId;
    private Car car;
    private String startDate;
    private String endDate;
    private String location;

    // add user and display info about user in reservation



}
