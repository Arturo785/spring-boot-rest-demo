package com.example.demo.controllers;

import com.example.demo.entity.Customer;
import com.example.demo.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/apiV2")
public class CustomerRestControllerV2 {

  private final CustomerService customerService;

  @Autowired
  public CustomerRestControllerV2(
      @Qualifier("customerServiceImplJPA") CustomerService customerService) {
    this.customerService = customerService;
  }

  @GetMapping("/customers")
  public List<Customer> findAll() {
    return customerService.findAll();
  }

  @GetMapping("/customers/{id}")
  public Customer getEmployee(@PathVariable int id) {
    Customer customer = customerService.findById(id);

    if (customer == null) {
      throw new RuntimeException("Customer not found : " + id);
    }

    return customer;
  }

  @PostMapping("/customers")
  public Customer addCustomer(@RequestBody Customer customer) {
    customer.setId(0); // to avoid user passing id

    customerService.save(customer);

    return customer;
  }

  @PutMapping("/customers")
  public Customer updateCustomer(@RequestBody Customer customer) {
    customerService.save(customer);
    return customer;
  }

  @DeleteMapping("/customers/{id}")
  public String deleteEmployee(@PathVariable int id) {
    Customer customer = customerService.findById(id);

    if (customer == null) {
      throw new RuntimeException("Customer not found : " + id);
    }

    customerService.delete(id);
    return "deleted";
  }
}
