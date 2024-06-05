package com.example.springcrud.entity;


import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.sql.Date;
import java.sql.Time;

@Getter
@Entity
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Reservation {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;

    Integer companions; //Number of companions
    Date date; //date of reservation
    Time hour; //hour of reservation
    String status; //status of reservation
    Integer code; //code of reservation

    @ManyToOne
    @JoinColumn(name = "table_id")
    @JsonManagedReference
    private RestaurantTable restaurantTable;

    @ManyToOne
    @JoinColumn(name = "customer_id")
    private Customer customer;

}
