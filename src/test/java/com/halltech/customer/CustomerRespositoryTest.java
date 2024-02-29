package com.halltech.customer;

import com.halltech.AbstractTestcontainerUnitTest;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.context.ApplicationContext;

import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
class CustomerRespositoryTest  {

    @Autowired
    private CustomerRespository underTest;

    @Autowired
    private ApplicationContext applicationContext;
    @BeforeEach
    void setUp(){
        System.out.println(applicationContext.getBeanDefinitionCount());
    }

    @Test
    void existsCustomerById() {
        String email = "deviean";
        Customer customer = new Customer(10, "ola", email);

//        When
        underTest.save(customer);
        int id = underTest.findAll().stream().filter(c -> c.getEmail().equals(email))
                .map(Customer::getId).findFirst().orElseThrow();

      var actual = underTest.existsCustomerById(id);
        assertThat(actual).isTrue();

    }

    @Test
    void existsCustomerByEmail() {
    }
}