package com.example.carrental.controller;


import com.example.carrental.dto.CarDTO;
import com.example.carrental.service.CarService;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@CrossOrigin()
@RequestMapping("/availablecars")
public class CarInventoryController {


    private CarService carService;

    public CarInventoryController(CarService carService) {
        this.carService = carService;
    }

    @GetMapping()
    public List<CarDTO> getAvailableCars() {
       return carService.getAvailableCars();
    }

}



