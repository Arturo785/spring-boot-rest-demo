package com.example.demo.repository;

import com.example.demo.entity.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;


// this is for spring data rest that generates our endpoints by itself, check on
// internet how it works
@RepositoryRestResource(path = "members")
public interface CustomerRepository extends JpaRepository<Customer, Integer> {}
