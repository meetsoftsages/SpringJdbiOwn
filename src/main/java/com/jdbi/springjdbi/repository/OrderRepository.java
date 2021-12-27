package com.jdbi.springjdbi.repository;

import com.jdbi.springjdbi.domain.Order;
import org.jdbi.v3.core.Handle;
import org.jdbi.v3.core.Jdbi;
import org.jdbi.v3.core.mapper.reflect.BeanMapper;
import org.jdbi.v3.core.mapper.reflect.FieldMapper;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public class OrderRepository implements OrderRepoInterface {
    Jdbi jdbi = Jdbi.create("jdbc:postgresql://localhost:5432/postgres", "postgres", "postgres");


    @Override
    public List<Order> getAllOrder() {
        try {
            return jdbi.withHandle(handle ->
                    handle.createQuery("select * from \"order\" ")
                            .map(new OrderMapper())
                            .list());
        } catch (Exception e) {
            throw new RuntimeException(e + "Error 1");
        }
    }

    @Override
    public Optional<Order> getById(int id) {

        try (Handle handle = jdbi.open();) {
            handle.registerRowMapper(FieldMapper.factory(Order.class));
            Optional<Order> orders = handle.createQuery("select * from \"order\" where id=:id")
                    .bind("id", id)
                    .mapTo(Order.class)
                    .findFirst();
            handle.close();
            return orders;
        } catch (Exception e) {
            throw new RuntimeException(e + "Error 2");
        }
    }

    @Override
    public String createOrder(Order order) {
        try (Handle handle = jdbi.open()) {
            handle.registerRowMapper(FieldMapper.factory(Order.class));
            handle.createUpdate("insert into \"order\" (id,order_name,quantity) values (:id,:order_name,:quantity)")
                    .bindBean(order)
                    .execute();
            handle.close();
            return "Order successfully inserted";
        } catch (Exception e) {
            throw new RuntimeException(e + "Error 3");
        }
    }

    @Override
    public String deleteOrder(int id) {
        try (Handle handle = jdbi.open()) {
            handle.registerRowMapper(FieldMapper.factory(Order.class));
            handle.createUpdate("delete from \"order\" where id=:id")
                    .bind("id", id)
                    .execute();
            handle.close();
            return "1";
        } catch (Exception e) {
            throw new RuntimeException(e + "Error 4");
        }
    }

    @Override
    public String updateOrder(Order order,int identity_number) {
        try (Handle handle = jdbi.open();) {
            handle.registerRowMapper(FieldMapper.factory(Order.class));
            handle.createUpdate("update \"order\" set id=:id,order_name=:order_name,quantity=:quantity where id=:id")
                    .bindBean(order)
                    //.bind("id",order.getId()).bind("order_name",order.getOrder_name()).bind("quantity",order.getQuantity())
                    .bind("id",identity_number)
                    .execute();
            handle.close();
            return "Order successfully updated";
        } catch (Exception e) {
            throw new RuntimeException(e + "Error 5");
        }
    }

}


