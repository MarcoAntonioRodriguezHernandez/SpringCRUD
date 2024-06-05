package com.example.springcrud.repository;

import com.example.springcrud.entity.RestaurantTable;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TableRepository extends JpaRepository<RestaurantTable,Long> {
}
