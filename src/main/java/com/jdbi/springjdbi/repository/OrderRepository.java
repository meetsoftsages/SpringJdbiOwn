package com.jdbi.springjdbi.repository;


import com.jdbi.springjdbi.domain.Order;
import org.jdbi.v3.core.Handle;
import org.jdbi.v3.core.Jdbi;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Repository;
import org.springframework.util.Assert;


import java.util.List;

@Repository
public class OrderRepository implements OrderRepoInterface {
    Jdbi jdbi = Jdbi.create("jdbc:postgresql://localhost:5432/postgres", "postgres", "postgres");

    public List<Order> getAllOrder() {
        return jdbi.withHandle(handle ->
                handle.createQuery("select * from order ")
                .mapTo(Order.class)
                .list());
    }
//    List<Order> getOrderById = jdbi.withHandle(handle -> {
//        return handle.createQuery("select * from order where id= :id order by id").bind("id", Order.getId()).mapTo(Order.class).list();
//    });
}

