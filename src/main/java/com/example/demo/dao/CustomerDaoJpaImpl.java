package com.example.demo.dao;

import com.example.demo.entity.Customer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import java.util.List;

@Repository
public class CustomerDaoJpaImpl implements CustomerDao {

  private final EntityManager entityManager;

  @Autowired
  public CustomerDaoJpaImpl(EntityManager entityManager) {
    this.entityManager = entityManager;
  }

  @Override
  public List<Customer> findAll() {
    Query query = entityManager.createQuery("from Customer");

    return query.getResultList();
  }

  @Override
  public Customer findById(int id) {
    return entityManager.find(Customer.class, id);
  }

  @Override
  public void save(Customer customer) {
    Customer currentCustomer = entityManager.merge(customer);
    customer.setId(currentCustomer.getId()); // updates the reference
  }

  @Override
  public void delete(int id) {
    Query query = entityManager.createQuery("delete from Customer where id=:id");

    query.setParameter("id", id);
    query.executeUpdate();
  }
}
