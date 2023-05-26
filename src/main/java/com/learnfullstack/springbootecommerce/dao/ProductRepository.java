package com.learnfullstack.springbootecommerce.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.learnfullstack.springbootecommerce.entity.Product;

public interface ProductRepository extends JpaRepository<Product, Long> {
  
}
