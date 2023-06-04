package com.learnfullstack.springbootecommerce.service;

import com.learnfullstack.springbootecommerce.dto.Purchase;
import com.learnfullstack.springbootecommerce.dto.PurchaseResponse;

public interface CheckoutService {
  
  PurchaseResponse placeOrder(Purchase purchase);

}
