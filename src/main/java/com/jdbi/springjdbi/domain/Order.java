package com.jdbi.springjdbi.domain;

public class Order {
    private int id;
    private String order_name;
    private int quantity;

    public Order(int id, String order_name, int quantity) {
        this.id = id;
        this.order_name = order_name;
        this.quantity=quantity;
    }

    public Order() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getOrder_name() {
        return order_name;
    }

    public void setOrder_name(String order_name) {
        this.order_name = order_name;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }
}
