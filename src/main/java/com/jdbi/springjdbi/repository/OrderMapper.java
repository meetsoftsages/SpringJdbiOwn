package com.jdbi.springjdbi.repository;

import com.jdbi.springjdbi.domain.Order;
import com.jdbi.springjdbi.service.OrderService;
import org.jdbi.v3.core.mapper.RowMapper;
import org.jdbi.v3.core.statement.StatementContext;

import javax.swing.*;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.Locale;

import static org.hibernate.criterion.Projections.id;


public class OrderMapper implements RowMapper<Order> {

    @Override
    public Order map(ResultSet rs, StatementContext ctx) throws SQLException {
//        return new Order(rs.getInt("id"),rs.getString("order_name"),rs.getInt("quantity"),rs.getInt("amount"));
        return new Order(rs.getInt("id"),rs.getString("order_name"),rs.getInt("quantity"));
    }
}

