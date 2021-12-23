package com.jdbi.springjdbi.service;


import com.jdbi.springjdbi.domain.Order;
import com.jdbi.springjdbi.repository.OrderRepository;
import org.springframework.context.annotation.Bean;

import java.util.List;

public class OrderService {
    public OrderRepository orderRepository;

    public OrderService(OrderRepository orderRepository) {
        this.orderRepository = orderRepository;
    }


    public List<Order> getAllOrders(){
        return orderRepository.getAllOrder();
    }
}
