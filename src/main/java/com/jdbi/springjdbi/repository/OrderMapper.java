package com.jdbi.springjdbi.repository;

import com.jdbi.springjdbi.domain.Order;
import org.jdbi.v3.core.mapper.RowMapper;
import org.jdbi.v3.core.statement.StatementContext;
import java.sql.ResultSet;
import java.sql.SQLException;

public class OrderMapper implements RowMapper<Order> {

    @Override
    public Order map(ResultSet rs, StatementContext ctx) throws SQLException {
//        return new Order(rs.getInt("id"),rs.getString("order_name"),rs.getInt("quantity"),rs.getInt("amount"));
        return new Order(rs.getInt("id"),rs.getString("order_name"),rs.getInt("quantity"));
    }
}

