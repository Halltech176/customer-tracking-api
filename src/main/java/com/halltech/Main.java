package com.halltech;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@SpringBootApplication()
@RestController
public class Main {
    private static List<Customer> customers;
    static  {
        Customer user1 = new Customer(1,"Halltech", "devhalltech@gmail.com", 20);
        Customer user2 = new Customer(2,"Olayemi", "olayemiayomide642@gmail.com", 21);
        customers = new ArrayList<>();
        customers.add(user1);
        customers.add(user2);
    }

    public static void main(String[] args) {
        SpringApplication.run(Main.class, args);
    }
    @RequestMapping(path = "api/v1/customers", method = RequestMethod.GET)
//    @GetMapping("api/v1/customer")
    public List<Customer> getCustomers() {
        return  customers;
    }

    @GetMapping("/api/v1/customers/{customerId}")
    public Customer getCustomer(@PathVariable("customerId") Integer customerId){
        return customers.stream()
                .filter(value -> value.id.equals(customerId))
                .findFirst()
                .orElseThrow(() -> new IllegalArgumentException("customer with this id does not exist"));
    }

    static public class Customer {
        private Integer id;
        private String name;
        private String email;
        private Integer age;


        public Customer(){}

        public Customer(Integer id, String name, String email,Integer age ){
            this.id = id;
            this.age = age;
            this.name = name;
            this.email = email;
        }

        public void setAge(Integer age) {
            this.age = age;
        }

        public Integer getAge() {
            return age;
        }

        public Integer getId() {
            return id;
        }

        public void setId(Integer id) {
            this.id = id;
        }

        public void setEmail(String email) {
            this.email = email;
        }

        public String getEmail() {
            return email;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            Customer customer = (Customer) o;
            return Objects.equals(id, customer.id) && Objects.equals(name, customer.name) && Objects.equals(email, customer.email) && Objects.equals(age, customer.age);
        }

        @Override
        public int hashCode() {
            return Objects.hash(id, name, email, age);
        }

        @Override
        public String toString() {
            return "Customer{" +
                    "id=" + id +
                    ", name='" + name + '\'' +
                    ", email='" + email + '\'' +
                    ", age=" + age +
                    '}';
        }
    }



}
