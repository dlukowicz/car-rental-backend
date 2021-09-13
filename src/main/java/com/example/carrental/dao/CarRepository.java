package com.example.carrental.dao;

import com.example.carrental.model.Car;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CarRepository extends JpaRepository<Car, Integer> {
   List<Car> findByCountGreaterThan(Integer count);
}
