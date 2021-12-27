package com.jdbi.springjdbi.repository;

import com.jdbi.springjdbi.domain.Order;

import java.util.List;
import java.util.Optional;

public interface OrderRepoInterface {
    List<Order> getAllOrder();
    Optional<Order> getById(int id);
    String  createOrder(Order order);
    String deleteOrder(int id);
    String updateOrder(Order order, int id);
}
