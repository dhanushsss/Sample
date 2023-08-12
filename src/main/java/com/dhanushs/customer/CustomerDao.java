package com.dhanushs.customer;

import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;


public interface CustomerDao {

    List<Customer> selectAllCustomer();
    Optional<Customer> selectCustomerById(Integer customerId);
    void getCustomer(Customer customer);

    boolean existsPersonWithEmail(String email);

}
