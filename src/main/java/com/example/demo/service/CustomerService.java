package com.example.demo.service;

import com.example.demo.entity.Customer;

import java.util.List;


public interface CustomerService {

  public List<Customer> findAll();

  public Customer findById(int id);

  public void save(Customer customer);

  public void delete(int id);
}
