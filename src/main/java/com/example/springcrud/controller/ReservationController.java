package com.example.springcrud.controller;

import com.example.springcrud.entity.Customer;
import com.example.springcrud.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class ReservationController {
    @Autowired
    CustomerService customerRepository;

    @GetMapping("/reservation")
    public List<Customer> getCustomers() {
        return customerRepository.listCustomer();
    }
}
