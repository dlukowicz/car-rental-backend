package com.example.carrental.dao;

import com.example.carrental.model.Reservation;
import com.example.carrental.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import javax.persistence.Id;
import java.util.List;

@Repository
public interface CarReservationRepository extends JpaRepository<Reservation, Integer> {

    List<Reservation> findByUser(User user);

}
