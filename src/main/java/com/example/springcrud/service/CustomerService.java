package com.example.springcrud.service;

import com.example.springcrud.dto.CustomerDTO;
import com.example.springcrud.entity.Customer;
import com.example.springcrud.repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CustomerService {
    @Autowired
    CustomerRepository customerRepo;

    public Customer saveCustomer(Customer customer) {
        return customerRepo.save(customer);
    }

    public CustomerDTO getCustomerById(Long id) {
        Customer customer = customerRepo.findById(id).orElse(null);
        CustomerDTO customerDTO = new CustomerDTO(customer.getId(), customer.getName(), customer.getEmail(), customer.getPhone());
        return customerDTO;
    }

    public Customer updateCustomer(Customer customer) {
        Customer existingCustomer = customerRepo.findById(customer.getId()).orElse(null);
        existingCustomer.setName(customer.getName());
        existingCustomer.setEmail(customer.getEmail());
        existingCustomer.setPhone(customer.getPhone());
        existingCustomer.setAddress(customer.getAddress());
        return customerRepo.save(existingCustomer);
    }

    public String deleteCustomer(Long id) {
        customerRepo.deleteById(id);
        return "Customer removed !! " + id;
    }

    public List<Customer> listCustomer() {
        return customerRepo.findAll();
    }



}
