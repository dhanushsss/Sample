package com.dhanushs.customer.repository;

import com.dhanushs.customer.model.Customer;
import org.springframework.data.jpa.repository.JpaRepository;

//@Repository
public interface CustomerRepository extends JpaRepository<Customer,Integer> {

    boolean existsCustomerByEmail(String email);
    boolean existsPersonWithId(Integer customerId);
}
