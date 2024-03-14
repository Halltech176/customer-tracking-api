package com.halltech;

import com.github.javafaker.Faker;
import com.github.javafaker.Name;
import com.halltech.customer.Customer;
import com.halltech.customer.CustomerRespository;
import com.halltech.customer.Gender;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.Random;


@SpringBootApplication
public class Main {


    static String myProperty;

    public static void main(String[] args) {
        SpringApplication.run(Main.class, args);

    }

    @Bean
    CommandLineRunner runner(CustomerRespository customerRespository) {
        return args -> {
            var faker = new Faker();
            Random random = new Random();
            Name name = faker.name();
            String firstName = name.firstName();
            String lastName = name.lastName();

            Customer customer = new Customer(
                    random.nextInt(16, 99),
                    firstName + " " + lastName,
                    firstName.toLowerCase() + "@gmail.com",
                    Gender.MALE);
            customerRespository.save(customer);
        };
    }

}
