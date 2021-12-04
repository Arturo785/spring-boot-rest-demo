package com.example.demo.controllers;

import com.example.demo.entity.Customer;
import com.example.demo.service.CustomerService;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/customers")
public class CustomerController {

  private final CustomerService customerService;

  public CustomerController(@Qualifier("customerServiceImplJPA") CustomerService customerService) {
    this.customerService = customerService;
  }

  @GetMapping("/list")
  public String listCustomers(Model model) {

    model.addAttribute("customers", customerService.findAll());

    return "customers/list-customers";
  }

  @GetMapping("/showFormAdd")
  public String showFormAdd(Model model) {
    model.addAttribute("customer", new Customer());

    return "customers/customer-form";
  }

  @GetMapping("/showFormUpdate")
  public String showFormUpdate(Model model, @RequestParam("customerId") int id) {
    model.addAttribute("customer", new Customer());

    model.addAttribute("customer", customerService.findById(id));

    return "customers/customer-form";
  }

  @GetMapping("/delete")
  public String deleteCustomer(@RequestParam("customerId") int id) {
    customerService.delete(id);
    return "redirect:/customers/list";
  }

  @PostMapping("/save")
  public String saveCustomer(@ModelAttribute("customer") Customer customer) {
    customerService.save(customer);
    return "redirect:/customers/list";
  }
}
