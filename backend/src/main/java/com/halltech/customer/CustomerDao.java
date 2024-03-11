package com.halltech.customer;

import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

//@Repository
public interface CustomerDao {
    List<Customer> selectAllCustomers();
    Optional<Customer> selectCustomerById(Integer id);

    void insertCustomer(Customer customer);

    void deleteCustomerById(Integer id);


    boolean existsPersonWithEmail(String email);
    boolean existsPersonWithId(Integer id);

    void updateCustomer(Customer update);


}
