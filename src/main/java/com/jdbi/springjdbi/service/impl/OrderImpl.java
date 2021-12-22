package com.jdbi.springjdbi.service.impl;

import com.jdbi.springjdbi.domain.Order;
import com.jdbi.springjdbi.repository.OrderRepository;
import com.jdbi.springjdbi.service.OrderService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrderImpl implements OrderService {

    private OrderRepository orderRepository;

    public OrderImpl(OrderRepository orderRepository) {
        this.orderRepository = orderRepository;
    }

    @Override
    public Order saveOrder(Order order) {
        return null;
    }

    @Override
    public List<Order> getAllOrder() {
        return null;
    }

    @Override
    public Order getOrderById(int id) {
        return null;
    }

    @Override
    public Order updateOrder(Order order, int id) {
        return null;
    }

    @Override
    public void deleteOrder(int id) {

    }
}
