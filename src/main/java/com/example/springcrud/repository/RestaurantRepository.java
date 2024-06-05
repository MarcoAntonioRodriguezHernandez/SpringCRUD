package com.example.springcrud.repository;

import com.example.springcrud.entity.Reservation;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RestaurantRepository extends JpaRepository<Reservation, Long> {

}
