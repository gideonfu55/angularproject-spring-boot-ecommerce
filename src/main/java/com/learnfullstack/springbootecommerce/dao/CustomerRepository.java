package com.learnfullstack.springbootecommerce.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.learnfullstack.springbootecommerce.entity.Customer;

public interface CustomerRepository extends JpaRepository <Customer, Long> {
  
  Customer findByEmail (String theEmail);

}
