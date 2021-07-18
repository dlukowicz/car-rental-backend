package com.example.carrental.controller;


import com.example.carrental.model.Car;
import com.example.carrental.service.CarRentalService;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;

@RestController
@CrossOrigin()
@RequestMapping("/availablecars")
public class CarInventoryController {


    private CarRentalService carRentalService;

    public CarInventoryController(CarRentalService carRentalService) {
        this.carRentalService = carRentalService;
    }

    @GetMapping()
    public ArrayList<Car> getAvailableCars() {
        return carRentalService.getAvailableCars();
    }

}



