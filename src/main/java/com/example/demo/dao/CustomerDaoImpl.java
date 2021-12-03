package com.example.demo.dao;

import com.example.demo.entity.Customer;
import org.hibernate.Session;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import java.util.List;

@Repository
public class CustomerDaoImpl implements CustomerDao {

  private final EntityManager entityManager;

  @Autowired
  public CustomerDaoImpl(EntityManager entityManager) {
    this.entityManager = entityManager;
  }

  @Override
  public List<Customer> findAll() {
    Session session = entityManager.unwrap(Session.class);

    Query<Customer> query = session.createQuery("from Customer", Customer.class);

    return query.getResultList();
  }

  @Override
  public Customer findById(int id) {
    Session session = entityManager.unwrap(Session.class);

    return session.get(Customer.class, id);
  }

  @Override
  public void save(Customer customer) {
    Session session = entityManager.unwrap(Session.class);

    session.saveOrUpdate(customer);
  }

  @Override
  public void delete(int id) {
    Session session = entityManager.unwrap(Session.class);

    Query query = session.createQuery("delete from Customer where id=:id");
    query.setParameter("id", id);

    query.executeUpdate();
  }
}
