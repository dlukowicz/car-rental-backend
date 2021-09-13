package com.example.carrental.service;

import com.example.carrental.dao.CarRepository;
import com.example.carrental.dto.CarDTO;
import com.example.carrental.dto.CreateReservationDTO;
import com.example.carrental.dto.ReservationDTO;
import com.example.carrental.model.Car;

import com.example.carrental.model.Reservation;
import lombok.extern.java.Log;
import org.assertj.core.util.Lists;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Log
@Service
public class CarService {

    private UserService userService;
    private CarRepository carRepository;


    public CarService(UserService userService, CarRepository carRepository) {
        this.userService = userService;
        this.carRepository = carRepository;
    }

    //TO DO zrobic stan liczby samochodow i odejmowac przy wynajmie
    public List<CarDTO> getAvailableCars(){
        List<Car> cars = carRepository.findByCountGreaterThan(0);
        return mapToDtoList(cars);
    }

    public Optional<Car> getCarInfo(Integer carId){
       return carRepository.findById(carId);
    }

    public void rentCar(Integer carId){
        Optional<Car> car = getCarInfo(carId);
        if(car.isPresent()){
            car.get().setCount(car.get().getCount()-1);
        }
    }

    public void completeRentCar(Integer carId){
        Optional<Car> car = getCarInfo(carId);
        if(car.isPresent()){
            car.get().setCount(car.get().getCount()+1);
        }
    }


    private List<CarDTO> mapToDtoList(List<Car> cars) {
        List<CarDTO> carDTOList = new ArrayList<>();
        for(int i=0; i<cars.size(); ++i){
            carDTOList.add(new CarDTO(cars.get(i).getId(), cars.get(i).getName(), cars.get(i).getFuel(), cars.get(i).getYear(),
                    cars.get(i).getDescription(), cars.get(i).getMileage(),
                    cars.get(i).getImgsrc(),cars.get(i).getCount(), cars.get(i).getPrice()));
        }
        return carDTOList;

    }

}
