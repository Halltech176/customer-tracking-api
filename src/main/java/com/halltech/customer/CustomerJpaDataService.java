package com.halltech.customer;

import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
@Repository("jpa")
public class CustomerJpaDataService implements  CustomerDao{
    private final CustomerRespository customerRespository;


    public CustomerJpaDataService(CustomerRespository customerRespository){
        this.customerRespository = customerRespository;
    }

    @Override
    public List<Customer> selectAllCustomers() {
        return customerRespository.findAll();
    }

    @Override
    public Optional<Customer> selectCustomerById(Integer id) {
        return Optional.empty();
    }

    @Override
    public void insertCustomer(Customer customer) {
        customerRespository.save(customer);
    }

    @Override
    public void deleteCustomerById(Integer id) {
        customerRespository.deleteById(id);
    }

    @Override
    public boolean existsPersonWithEmail(String email) {
        return customerRespository.existsCustomerByEmail(email);

    }

    @Override
    public boolean existsPersonWithId(Integer id) {
        return customerRespository.existsCustomerById(id);
    }

    @Override
    public void updateCustomer(Customer update) {
        customerRespository.save(update);
    }


}
