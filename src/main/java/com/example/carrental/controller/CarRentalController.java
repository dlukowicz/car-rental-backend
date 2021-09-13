package com.example.carrental.controller;

import com.example.carrental.dto.CreateReservationDTO;
import com.example.carrental.dto.ReservationDTO;
import com.example.carrental.service.CarReservationService;
import com.example.carrental.service.CarService;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

@RestController
@CrossOrigin()
@RequestMapping("/reservations")
public class CarRentalController {


    private CarReservationService carReservationService;

    public CarRentalController(CarReservationService carReservationService) {
        this.carReservationService = carReservationService;
    }

    @PostMapping()
    public void createRent(@RequestBody CreateReservationDTO createReservationDTO) {
         carReservationService.createReservation(createReservationDTO);
    }

    @GetMapping("/user/{userId}")
    public ArrayList<ReservationDTO> getRentsByUserId(@PathVariable Long userId) {
        return carReservationService.getRentsByUserId(userId);
    }

    @DeleteMapping
    public void completeRental(@RequestBody ReservationDTO reservationDTO){
        carReservationService.completeReservation(reservationDTO);
    }
}
