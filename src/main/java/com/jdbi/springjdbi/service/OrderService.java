package com.jdbi.springjdbi.service;


import com.jdbi.springjdbi.domain.Order;
import com.jdbi.springjdbi.repository.OrderRepository;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrderService {
    public OrderRepository orderRepository;

    public OrderService(OrderRepository orderRepository) {
        this.orderRepository = orderRepository;
    }


    public List<Order> getAllOrders() {
        return orderRepository.getAllOrder();
    }

    public List<Order> getById() {
        return orderRepository.getById();
    }

    public String createOrder(){
        return orderRepository.createOrder();
    }

    public String deleteOrder(){
        return orderRepository.deleteOrder();
    }
    public String updateOrder(){
        return orderRepository.updateOrder();
    }
}

