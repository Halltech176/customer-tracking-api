    package com.halltech.customer;

    import jakarta.persistence.*;

    import java.util.Objects;


    @Entity
    @Table(
            name = "customer",
            uniqueConstraints = {
                    @UniqueConstraint(
                            name = "customer_email_unique",
                            columnNames = "email"
                    )
            }
    )
     public class Customer{

        @Id
        @SequenceGenerator(
                name = "customer_id_seq",
                sequenceName = "customer_id_seq",
                allocationSize = 1
        )
        @GeneratedValue(
                strategy = GenerationType.SEQUENCE,
                generator = "customer_id_seq"
        )
        public Integer id;


        @Column(
                nullable = false
        )
        private Integer age;

        @Column(
                nullable = false
        )
        private String name;

        @Column(
                nullable = false,
                unique = true
        )
        private String email;

        @Column(
                nullable = false
        )
        @Enumerated(EnumType.STRING)
        private Gender gender;

        public Customer(){}
        public Customer(Integer id, Integer age, String name, String email){
            this.age = age;
            this.id = id;
            this.name = name;
            this.email = email;
        }

        public Customer(Integer age, String name, String email) {
            this.age = age;
            this.name = name;
            this.email = email;
        }

        public void setName(String name) {
            this.name = name;
        }

        public String getName() {
            return name;
        }

        public void setId(Integer id) {
            this.id = id;
        }

        public Integer getId() {
            return id;
        }

        public String getEmail() {
            return email;
        }

        public void setEmail(String email) {
            this.email = email;
        }

        public Integer getAge() {
            return age;
        }

        public void setAge(Integer age) {
            this.age = age;
        }

        @Override
        public int hashCode() {
            return super.hashCode();
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            Customer customer = (Customer) o;
            return Objects.equals(age, customer.age) && Objects.equals(id, customer.id) && Objects.equals(name, customer.name) && Objects.equals(email, customer.email);
        }

        @Override
        public String toString() {
            return "Customer{" +
                    "age=" + age +
                    ", id=" + id +
                    ", name='" + name + '\'' +
                    ", email='" + email + '\'' +
                    '}';
        }
    }