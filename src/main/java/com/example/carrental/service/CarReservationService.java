package com.example.carrental.service;

import com.example.carrental.dao.CarReservationRepository;
import com.example.carrental.dto.CreateReservationDTO;
import com.example.carrental.dto.ReservationDTO;
import com.example.carrental.model.Car;
import com.example.carrental.model.Reservation;
import com.example.carrental.model.User;
import lombok.extern.java.Log;
import org.assertj.core.util.Lists;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Optional;

@Log
@Service
public class CarReservationService {

    private CarReservationRepository carReservationRepository;
    private CarService carService;
    private UserService userService;

    public CarReservationService(CarReservationRepository carReservationRepository, CarService carService,UserService userService) {
        this.carReservationRepository = carReservationRepository;
        this.carService = carService;
        this.userService = userService;
    }

    public void createReservation(CreateReservationDTO createReservationDTO) {
        log.info("Create reservation " + createReservationDTO);

        carReservationRepository.save(mapToReservation(createReservationDTO));

    }

    public ArrayList<ReservationDTO> getRentsByUserId(Long userId) {
        if(userService.isAdmin()){
            return mapToReservationDtoList(carReservationRepository.findAll());

        } else {
            Optional<User> user = userService.getUserById(userId);
            if (user.isPresent()) {
                return mapToReservationDtoList(carReservationRepository.findByUser(user.get()));
            }
            else {
                return new ArrayList<>();
            }

        }
    }

    private ArrayList<ReservationDTO> mapToReservationDtoList(List<Reservation> reservations) {
        ArrayList<ReservationDTO> reservationDTOList = new ArrayList<>();

        for (int i = 0; i < reservations.size() ; i++) {
            reservationDTOList.add(mapToReservationDto(reservations.get(i)));
        }

        return reservationDTOList;

    }

    private ReservationDTO mapToReservationDto(Reservation reservation) {
        ReservationDTO reservationDTO = new ReservationDTO();
        reservationDTO.setCar(reservation.getCarId());
        reservationDTO.setLocation(reservation.getLocation());
        //TODO dopisac date start date end

        return reservationDTO;

    }

    private Reservation mapToReservation(CreateReservationDTO createReservationDTO) {
        Car car = carService.getCarInfo(createReservationDTO.getCarId()).orElse(null);
        User user = userService.getUserById(createReservationDTO.getUserId()).orElse(null);
        return new Reservation(car, user, createReservationDTO.getName(), createReservationDTO.getSurname(), createReservationDTO.getEmail(), createReservationDTO.getLocation());
    }


}
