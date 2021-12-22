package com.jdbi.springjdbi.repository;

import com.jdbi.springjdbi.domain.Order;
import org.jdbi.v3.core.Handle;
import org.jdbi.v3.core.Jdbi;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class OrderRepository {
    Jdbi jdbi=Jdbi.create("jdbc:postgresql://localhost:5432/postgres","postgres","postgres");
    List<Order> orders=jdbi.withHandle(handle -> {return handle.createQuery("select * from order ").mapTo(Order.class).list();});
}
