package com.example.carrental.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
public class Reservation {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int reservationId;
    @ManyToOne
    @JoinColumn
    private Car carId;
    @ManyToOne
    @JoinColumn
    private User user;
    private String name;
    private String surname;
    private String email;
    private String location;


    public Reservation(Car car, User user, String name, String surname, String email, String location) {
        this.carId = car;
        this.user = user;
        this.name = name;
        this.surname = surname;
        this.email = email;
        this.location = location;
    }
}
