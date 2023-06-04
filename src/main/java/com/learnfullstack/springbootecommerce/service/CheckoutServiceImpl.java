package com.learnfullstack.springbootecommerce.service;

import java.util.Set;
import java.util.UUID;

import org.springframework.stereotype.Service;

import com.learnfullstack.springbootecommerce.dao.CustomerRepository;
import com.learnfullstack.springbootecommerce.dto.Purchase;
import com.learnfullstack.springbootecommerce.dto.PurchaseResponse;
import com.learnfullstack.springbootecommerce.entity.Customer;
import com.learnfullstack.springbootecommerce.entity.Order;
import com.learnfullstack.springbootecommerce.entity.OrderItem;

import jakarta.transaction.Transactional;

@Service
public class CheckoutServiceImpl implements CheckoutService {

  private CustomerRepository customerRepository;

  public CheckoutServiceImpl(CustomerRepository customerRepository) {
    this.customerRepository = customerRepository;
  }

  @Override
  @Transactional
  public PurchaseResponse placeOrder(Purchase purchase) {
    // Retrieve the order info from dto
    Order order = purchase.getOrder();

    // Generate tracking number
    String orderTrackingNumber = generateOrderTrackingNumber();
    order.setOrderTrackingNumber(orderTrackingNumber);

    // Populate order with orderItems
    Set<OrderItem> orderItems = purchase.getOrderItems();
    orderItems.forEach(item -> order.add(item));

    // Populate order with billingAddress and shippingAddress
    order.setBillingAddress(purchase.getBillingAddress());
    order.setShippingAddress(purchase.getShippingAddress());

    // Populate customer with order
    Customer customer = purchase.getCustomer();
    customer.add(order);

    // Save to database
    customerRepository.save(customer);
    
    // return response
    return new PurchaseResponse(orderTrackingNumber);
  }

  private String generateOrderTrackingNumber() {

    // Generate a random UUID number
    return UUID.randomUUID().toString();
  }
  
}
