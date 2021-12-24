package com.jdbi.springjdbi.repository;

import com.jdbi.springjdbi.domain.Order;
import org.jdbi.v3.core.Handle;
import org.jdbi.v3.core.Jdbi;
import org.jdbi.v3.core.mapper.reflect.FieldMapper;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public class OrderRepository implements OrderRepoInterface {
    Jdbi jdbi = Jdbi.create("jdbc:postgresql://localhost:5432/postgres", "postgres", "postgres");

    @Override
    public List<Order> getAllOrder() {
        try{
            return jdbi.withHandle(handle ->
                    handle.createQuery("select * from \"order\" ")
                            .map(new OrderMapper())
                            .list());
        }
        catch (Exception e){
            throw new RuntimeException();
        }
    }

    @Override
    public List<Order> getById() {

        try (Handle handle = jdbi.open();) {
            handle.registerRowMapper(FieldMapper.factory(Order.class));
            List<Order> orders = handle.createQuery("select * from \"order\" where id=:id")
                    .bind("id", 2)
                    .mapTo(Order.class)
                    .list();
            return orders;
        } catch (Exception e) {
            throw new RuntimeException(e + "Error 2");
        }
    }

    @Override
    public String createOrder() {
        try (Handle handle = jdbi.open();) {
            handle.registerRowMapper(FieldMapper.factory(Order.class));
            Order order = new Order(4, "demo", 1231);
            handle.createUpdate("insert into \"order\" (id,order_name,quantity) values (:id,:order_name,:quantity)")
                    .bindBean(order)
                    .execute();
            return "Order successfully inserted";
        } catch (Exception e) {
            throw new RuntimeException(e + "Error 3");
        }
    }

    @Override
    public String deleteOrder() {
        try {
            jdbi.useHandle(handle -> {
                handle.execute("delete from \"order\" where id=?", 4);
            });
            return "Order successfully deleted";
        } catch (Exception e) {
            throw new RuntimeException(e + "Error 4");
        }
    }

    @Override
    public String updateOrder() {
        try (Handle handle = jdbi.open();) {
            handle.registerRowMapper(FieldMapper.factory(Order.class));
            Order order = new Order(5, "demonew", 3232);
            handle.createUpdate("update \"order\" set id=?,order_name=?,quantity=? where id=?")
                    .bind(0,5).bind(1,"demonew").bind(2,321)
                    .bind(3,4)
                    .execute();
            return "Order successfully updated";
        } catch (Exception e) {
            throw new RuntimeException(e + "Error 5");
        }
    }

}


