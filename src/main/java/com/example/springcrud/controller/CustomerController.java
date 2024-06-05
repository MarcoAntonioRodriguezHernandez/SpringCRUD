package com.example.springcrud.controller;

import java.util.List;

import com.example.springcrud.dto.CustomerDTO;
import com.example.springcrud.entity.Customer;
import com.example.springcrud.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1")
public class CustomerController {
    @Autowired
    CustomerService customerService;

    @GetMapping("/customer")
    @ResponseBody
    public List<Customer> listCustomer() {
        return customerService.listCustomer();
    }

    @PostMapping(value = "/customer", consumes = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public Customer saveCustomer(@RequestBody Customer customer) {
        return customerService.saveCustomer(customer);
    }

    @GetMapping("/customer/{id}")
    @ResponseBody
    public CustomerDTO getCustomer(@PathVariable Long id) {
        return customerService.getCustomerById(id);
    }

    @PutMapping("/customer")
    @ResponseBody

    public Customer updateCustomer(@RequestBody Customer customer) {
        return customerService.updateCustomer(customer);
    }

    @DeleteMapping("/customer/{id}")
    public String deleteCustomer(@PathVariable Long id) {
        return customerService.deleteCustomer(id);
    }



}

