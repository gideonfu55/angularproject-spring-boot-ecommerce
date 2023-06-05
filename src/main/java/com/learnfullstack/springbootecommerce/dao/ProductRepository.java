package com.learnfullstack.springbootecommerce.dao;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;

import com.learnfullstack.springbootecommerce.entity.Product;

public interface ProductRepository extends JpaRepository<Product, Long> {

  Page<Product> findByCategoryId(@Param("id") Long id, Pageable pageable);
  Page<Product> findByNameContaining(@Param("name") String name, Pageable pageable);
  
}
