package com.codegym.service;

import com.codegym.model.Customer;
import com.codegym.repository.CustomerRepository;

public interface CustomerService {
    Iterable<Customer> findAll();
    Customer findById(Long id);
    void save(Customer customer);
    void deleteById(Long id);
}
