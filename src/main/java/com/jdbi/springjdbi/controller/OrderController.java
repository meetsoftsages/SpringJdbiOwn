package com.jdbi.springjdbi.controller;

import com.jdbi.springjdbi.domain.Order;
import com.jdbi.springjdbi.service.OrderService;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/order")
public class OrderController {

    public OrderService orderService;


    public OrderController(OrderService orderService) {
        this.orderService = orderService;
    }

    @GetMapping
    public List<Order> getAllOrder(){
        return orderService.getAllOrders();
    }

    @GetMapping("{id}")
    public Order getById(@PathVariable("id") int id){
        return orderService.getById(id);
    }

    @PostMapping()
    public String creatOrder(@RequestBody Order order){
       return orderService.createOrder(order);
    }

    @DeleteMapping("{id}")
    public String deleteOrder(@PathVariable("id")int id){
        return orderService.deleteOrder(id);
    }

    @PutMapping("{id}")
    public String updateOrder(@RequestBody Order order, @PathVariable("id")int id){
        return orderService.updateOrder(order,id);
    }
}
