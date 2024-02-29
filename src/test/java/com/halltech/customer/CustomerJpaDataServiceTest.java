package com.halltech.customer;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

import static org.junit.jupiter.api.Assertions.*;

class CustomerJpaDataServiceTest {

    private  CustomerJpaDataService underTest;
    private  AutoCloseable autoCloseable;
    @Mock
    private  CustomerRespository customerRespository;

    @BeforeEach
    void setUp(){
        autoCloseable = MockitoAnnotations.openMocks(this);
        underTest = new CustomerJpaDataService(customerRespository);
    }

    @AfterEach
    void tearDown() throws  Exception{
        autoCloseable.close();
    }

    @Test
    void selectAllCustomers() {
        underTest.selectAllCustomers();
        Mockito.verify(customerRespository).findAll();
    }

    @Test
    void selectCustomerById() {
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