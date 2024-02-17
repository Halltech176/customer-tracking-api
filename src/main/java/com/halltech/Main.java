package com.halltech;

import com.halltech.customer.Customer;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.web.bind.annotation.*;


@SpringBootApplication()
public class Main {

    public static void main(String[] args) {
      ConfigurableApplicationContext applicationContext = SpringApplication.run(Main.class, args);
    }





}
