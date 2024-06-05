package com.example.springcrud.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.Set;

@Getter
@Setter
@Entity

public class RestaurantTable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;
    @Basic
    Integer number; //table number
    String availableChairs; //Number of chairs available on table
    String zone; //place of table in restaurant


    @OneToMany(mappedBy = "restaurantTable")
    private Set<Reservation> reservations;
}
