package com.learnfullstack.springbootecommerce.service;

import org.springframework.stereotype.Service;

import com.learnfullstack.springbootecommerce.dao.CustomerRepository;
import com.learnfullstack.springbootecommerce.dto.Purchase;
import com.learnfullstack.springbootecommerce.dto.PurchaseResponse;

@Service
public class CheckoutServiceImpl implements CheckoutService {

  private CustomerRepository customerRepository;

  public CheckoutServiceImpl(CustomerRepository customerRepository) {
    this.customerRepository = customerRepository;
  }

  @Override
  public PurchaseResponse placeOrder(Purchase purchase) {
    return null;
  }
  
}
