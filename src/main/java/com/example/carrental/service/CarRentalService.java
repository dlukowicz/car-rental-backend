package com.example.carrental.service;

import com.example.carrental.dto.CreateReservationDTO;
import com.example.carrental.dto.ReservationDTO;
import com.example.carrental.model.Car;

import lombok.extern.java.Log;
import org.assertj.core.util.Lists;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Log
@Service
public class CarRentalService {


    public ArrayList<Car> getAvailableCars(){

        return  Lists.newArrayList(new Car(1,  "Mazda 3",  "petrol",  2019,  "Lorem Ipsum is simply dummy text of the printing and typesetting industry. " +
                "Lorem Ipsum has been the industry's standard dummy text ever since the 1500s, when an unknown printer took a galley of type and scrambled it to " +
                "make a type specimen book. ",
                25000, "../assets/mazda-3.jpg"),
                new Car(2,  "BMW 1","petrol",  2021,  "Lorem Ipsum is simply dummy text of the printing and typesetting industry. " +
                        "Lorem Ipsum has been the industry's standard dummy text ever since the 1500s, when an unknown printer took a galley of type and scrambled it to " +
                        "make a type specimen book. ",  1000, "../assets/bmw-1.jpg"),
                new Car( 3,  "Ford focus", "petrol", 2019, "Lorem Ipsum is simply dummy text of the printing and typesetting industry. " +
                        "Lorem Ipsum has been the industry's standard dummy text ever since the 1500s, when an unknown printer took a galley of type and scrambled it to " +
                        "make a type specimen book. ",  10000, "../assets/ford-focus.jpg"),
                new Car( 4,  "Mazda CX3",  "petrol",  2017,  "Lorem Ipsum is simply dummy text of the printing and typesetting industry. " +
                        "Lorem Ipsum has been the industry's standard dummy text ever since the 1500s, when an unknown printer took a galley of type and scrambled it to " +
                        "make a type specimen book. ", 55000, "../assets/mazda-cx3.jpg" ),
                new Car (   5,  "Volkswagen Passat",  "petrol",  2017,  "Lorem Ipsum is simply dummy text of the printing and typesetting industry. " +
                        "Lorem Ipsum has been the industry's standard dummy text ever since the 1500s, when an unknown printer took a galley of type and scrambled it to " +
                        "make a type specimen book. ",  100000,  "../assets/passat.jpg"),
                new Car(6,  "Seat Leon",  "petrol",  2020,  "Lorem Ipsum is simply dummy text of the printing and typesetting industry. " +
                        "Lorem Ipsum has been the industry's standard dummy text ever since the 1500s, when an unknown printer took a galley of type and scrambled it to " +
                        "make a type specimen book. ",  8000, "../assets/seat-leon.jpg"),
                new Car(    7, "Toyota Yaris","petrol",  2019,  "Lorem Ipsum is simply dummy text of the printing and typesetting industry. " +
                        "Lorem Ipsum has been the industry's standard dummy text ever since the 1500s, when an unknown printer took a galley of type and scrambled it to " +
                        "make a type specimen book. ", 15000,   "../assets/toyota-yaris.jpg"));
    }

    public CreateReservationDTO createReservation(CreateReservationDTO createReservationDTO) {
        log.info("Create reservation " + createReservationDTO);
        // repository.save

        return createReservationDTO;

    }


    public ArrayList<ReservationDTO> getRentsByUserId(String userId) {

        return Lists.newArrayList(new ReservationDTO(new Car(6,  "Seat Leon",  "petrol",  2020,  "Lorem Ipsum is simply dummy text of the printing and typesetting industry. " +
                "Lorem Ipsum has been the industry's standard dummy text ever since the 1500s, when an unknown printer took a galley of type and scrambled it to " +
                "make a type specimen book. ",  8000, "../assets/seat-leon.jpg"), "2021-07-11T22:00:00.000Z", "2021-07-15T22:00:00.000Z"));


    }
}
