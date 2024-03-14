package com.halltech.customer;


import com.halltech.AbstractTestcontainerUnitTest;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;

class CustomerJDBCDataAccessServiceTest extends AbstractTestcontainerUnitTest {
    private final CustomerRowMapper customerRowMapper = new CustomerRowMapper();
    private CustomerJDBCDataAccessService underTest;

    @BeforeEach
    void setUp() {
        underTest = new CustomerJDBCDataAccessService(
                getJdbcTemplate(),
                customerRowMapper
        );
    }

    @Test
    void selectAllCustomers() {
//        Given
        Customer customer = new Customer(10, "ola", "devman", Gender.MALE);

//        When
        underTest.insertCustomer(customer);

        List<Customer> customers = underTest.selectAllCustomers();

//        Then
        assertThat(customers).isNotEmpty();

    }

    @Test
    void selectCustomerById() {
        String email = "deviean";
        Customer customer = new Customer(10, "ola", email, Gender.MALE);

//        When
        underTest.insertCustomer(customer);
        int id = underTest.selectAllCustomers().stream().filter(c -> c.getEmail().equals(email))
                .map(Customer::getId).findFirst().orElseThrow();

        Optional<Customer> actual = underTest.selectCustomerById(id);
        assertThat(actual).isPresent().hasValueSatisfying(c -> {
            assertThat(c.getId()).isEqualTo(id);
        });
    }

    @Test
    void insertCustomer() {
    }

    @Test
    void deleteCustomerById() {
    }

    @Test
    void existsPersonWithEmail() {
    }

    @Test
    void existsPersonWithId() {
    }

    @Test
    void updateCustomer() {
    }
}