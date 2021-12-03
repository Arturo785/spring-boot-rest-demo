package com.example.demo.service;

import com.example.demo.entity.Customer;
import com.example.demo.repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CustomerServiceImplJPA implements CustomerService {

  private final CustomerRepository customerRepository;

  // uses the repository with JPA data api
  @Autowired
  public CustomerServiceImplJPA(CustomerRepository customerRepository) {
    this.customerRepository = customerRepository;
  }

  @Override
  public List<Customer> findAll() {
    return customerRepository.findAll();
  }

  @Override
  public Customer findById(int id) {
    Optional<Customer> customer = customerRepository.findById(id);

    // manage better exception
    return customer.orElseThrow(() -> new RuntimeException("Not found"));
  }

  @Override
  public void save(Customer customer) {
    customerRepository.save(customer);
  }

  @Override
  public void delete(int id) {
    customerRepository.deleteById(id);
  }
}
