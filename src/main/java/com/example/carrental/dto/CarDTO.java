package com.example.carrental.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class CarDTO {
    private Integer id;
    private String name;
    private String fuel;
    private int year;
    private String description;
    private float mileage;
    private String imgsrc;
    private Integer count;
    private Float price;

}
