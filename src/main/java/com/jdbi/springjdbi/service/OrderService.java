package com.jdbi.springjdbi.service;

import com.jdbi.springjdbi.domain.Order;
import com.jdbi.springjdbi.repository.OrderRepository;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class OrderService {
    public OrderRepository orderRepository;

    public OrderService(OrderRepository orderRepository) {
        this.orderRepository = orderRepository;
    }

    public List<Order> getAllOrders() {
        return orderRepository.getAllOrder();
    }

    public Order getById(int id) {
        Optional<Order> order = orderRepository.getById(id);
        if (order.isPresent())
        {
            return order.get();
        }
        else {
            throw new RuntimeException();
        }

    }

    public String createOrder(Order order) {
        return orderRepository.createOrder(order);
    }

    public String deleteOrder(int id) {

        if(id != -1){
            orderRepository.deleteOrder(id);
            return "Order successfully deleted";
        }
        else {
            throw new RuntimeException();
        }
    }

        public String updateOrder(Order order, int id) {
        return orderRepository.updateOrder(order,id);
    }
}

