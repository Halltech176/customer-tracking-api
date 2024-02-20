package com.halltech;

import com.halltech.customer.Customer;
import com.halltech.customer.CustomerRespository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@SpringBootApplication()
public class Main {

    public static void main(String[] args) {
      ConfigurableApplicationContext applicationContext = SpringApplication.run(Main.class, args);


    }
    @Bean
    CommandLineRunner runner(CustomerRespository customerRespository) {
        return args -> {
            Customer customer1 = new Customer(25, "Olajide", "devhiee" );
            Customer customer2 = new Customer(30, "Olayemi", "devtech" );

            List<Customer> customerList = List.of(customer1, customer2);
            customerRespository.saveAll(customerList);
        };
    }


}
