package com.learnfullstack.springbootecommerce.dto;

import java.util.Set;

import com.learnfullstack.springbootecommerce.entity.Address;
import com.learnfullstack.springbootecommerce.entity.Customer;
import com.learnfullstack.springbootecommerce.entity.Order;
import com.learnfullstack.springbootecommerce.entity.OrderItem;

import lombok.Data;

@Data
public class Purchase {

  private Customer customer;
  private Address shippingAddress;
  private Address billingAddress;
  private Order order;
  private Set<OrderItem> orderItems;
  
}
