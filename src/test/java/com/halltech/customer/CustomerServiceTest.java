package com.halltech.customer;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(MockitoExtension.class)
class CustomerServiceTest {

    @Mock
    private CustomerDao customerDao;
    private CustomerService underTest;


    @BeforeEach
    void setUp() {
        underTest = new CustomerService(customerDao);
    }


    @Test
    void getAllCustomers() {
        underTest.getAllCustomers();
        Mockito.verify(customerDao).selectAllCustomers();
    }

    @Test
    void getCustomerById() {

    }

    @Test
    void deleteCustomer() {
    }

    @Test
    void addCustomer() {
    }

    @Test
    void updateCustomer() {
    }
}