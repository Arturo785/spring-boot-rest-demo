package com.example.demo.dao;

import com.example.demo.entity.Customer;

import java.util.List;

public interface CustomerDao {

  public List<Customer> findAll();

  public Customer findById(int id);

  public void save(Customer customer);

  public void delete(int id);
}
