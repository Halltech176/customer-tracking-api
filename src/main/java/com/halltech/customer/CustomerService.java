package com.halltech.customer;

import com.halltech.exception.DuplicateResourceException;
import com.halltech.exception.RequestValidationException;
import com.halltech.exception.ResourceNotFound;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class CustomerService {
    private final CustomerDao customerDao;

    public CustomerService(@Qualifier("jpa") CustomerDao customerDao) {
        this.customerDao = customerDao;
    }

    public List<Customer> getAllCustomers(){
        return customerDao.selectAllCustomers();
    }

    public Customer getCustomerById(Integer id){
        return customerDao.selectCustomerById(id)
                .orElseThrow(() -> new ResourceNotFound(("Customer with id [%s] not found".formatted(id))));
    }

    public void deleteCustomer(Integer id){
        customerDao.deleteCustomerById(id);
    }


    public void addCustomer(CustomerRegistrationRequest customerRegistrationRequest){
//        check if the email exists
        if(customerDao.existsPersonWithEmail(customerRegistrationRequest.email())){
            throw new DuplicateResourceException("Email already exist");
        }
      Customer customer = new Customer(
              customerRegistrationRequest.age(),
              customerRegistrationRequest.name(),
              customerRegistrationRequest.email()
      );
        customerDao.insertCustomer(customer);
    }

    public void updateCustomer(Integer customerId, CustomerUpdateRequest updateRequest){
        Customer customer = getCustomerById(customerId);
        boolean changes = false;
        if(updateRequest.name() != null && !updateRequest.name().equals(customer.getName())) {
            customer.setName(updateRequest.name());
            changes = true;
        }
        if(updateRequest.age() != null && !updateRequest.age().equals(customer.getAge())) {
            customer.setAge(updateRequest.age());
            changes = true;
        }
        if(updateRequest.email() != null && !updateRequest.email().equals(customer.getEmail())) {
            customer.setEmail(updateRequest.email());
            changes = true;
        }

        if(!changes) {
            throw new RequestValidationException("no data changes found");
        }

        customerDao.updateCustomer(customer);

    }
}
