package com.example.carrental.controller;

import com.example.carrental.dto.CreateReservationDTO;
import com.example.carrental.dto.ReservationDTO;
import com.example.carrental.service.CarRentalService;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

@RestController
@CrossOrigin()
@RequestMapping("/reservations")
public class CarRentalController {


    private CarRentalService carRentalService;

    public CarRentalController(CarRentalService carRentalService) {
        this.carRentalService = carRentalService;
    }

    @PostMapping()
    public CreateReservationDTO createRent(@RequestBody CreateReservationDTO createReservationDTO) {
        return carRentalService.createReservation(createReservationDTO);
    }

    @GetMapping("/{userId}")
    public ArrayList<ReservationDTO> getRentsByUserId(@PathVariable String userId) {
        return carRentalService.getRentsByUserId(userId);
    }
}
