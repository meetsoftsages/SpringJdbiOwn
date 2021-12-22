package com.jdbi.springjdbi.service;

import com.jdbi.springjdbi.domain.Order;

import java.util.List;

public interface OrderService {

    Order saveOrder(Order order);
    List<Order> getAllOrder();
    Order getOrderById(int id);
    Order updateOrder(Order order,int id);
    void deleteOrder(int id);
}
