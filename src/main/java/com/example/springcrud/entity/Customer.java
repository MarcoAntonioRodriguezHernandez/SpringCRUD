package com.example.springcrud.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import com.example.springcrud.entity.Reservation;

import java.util.List;
import java.util.Set;

@Getter
@Setter
@Entity
public class Customer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;
    @Basic
    String name; // name of customer
    String email; // email of customer
    String phone; // phone number of customer
    String address; // address of customer



    @OneToMany(mappedBy = "customer")
    private Set<Reservation> reservations;
}
