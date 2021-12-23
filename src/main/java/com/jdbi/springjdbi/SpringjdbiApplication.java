package com.jdbi.springjdbi;

import com.jdbi.springjdbi.domain.Order;
import com.jdbi.springjdbi.repository.OrderRepository;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.List;

@SpringBootApplication
public class SpringjdbiApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringjdbiApplication.class, args);
    }

}
