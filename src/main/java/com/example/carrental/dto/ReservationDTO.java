package com.example.carrental.dto;

import com.example.carrental.model.Car;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class ReservationDTO {

    private Car car;
    private String startDate;
    private String endDate;



}
