package com.example.demo.service;

import com.example.demo.dao.CustomerDao;
import com.example.demo.dao.CustomerDaoJpaImpl;
import com.example.demo.entity.Customer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class CustomerServiceImpl implements CustomerService {

  private final CustomerDao customerDao;

  @Autowired // specify which bean to use
  public CustomerServiceImpl(@Qualifier("customerDaoJpaImpl") CustomerDao customerDao) {
    this.customerDao = customerDao;
  }

  @Override
  @Transactional
  public List<Customer> findAll() {
    return customerDao.findAll();
  }

  @Override
  @Transactional
  public Customer findById(int id) {
    return customerDao.findById(id);
  }

  @Override
  @Transactional
  public void save(Customer customer) {
    customerDao.save(customer);
  }

  @Override
  @Transactional
  public void delete(int id) {
    customerDao.delete(id);
  }
}
