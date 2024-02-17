package com.halltech.customer;

import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
@Repository
public class CustomerDataAccessService implements CustomerDao {

    private static final List<Customer> customers;

    static {
        customers = new ArrayList<>();

        Customer customer1 = new Customer(1,20, "Olayemi", "devhalltech@gmail.com");
        Customer customer2 = new Customer(2,21, "Ayomide", "olayemiaayomide6412@gmail.com");
        customers.add(customer1);
        customers.add(customer2);
    }
    @Override
    public List<Customer> selectAllCustomers() {
        return customers;
    }

    @Override
    public Optional<Customer> selectCustomerById(Integer id) {
        return customers.stream()
                .filter(value -> value.getId().equals(id))
                .findFirst();
    }

}
