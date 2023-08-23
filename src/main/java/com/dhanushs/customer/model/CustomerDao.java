package com.dhanushs.customer.model;

import com.dhanushs.customer.model.Customer;

import java.util.List;
import java.util.Optional;


public interface CustomerDao {

    List<Customer> selectAllCustomer();
    Optional<Customer> selectCustomerById(Integer customerId);
    void getCustomer(Customer customer);
    boolean existsPersonWithEmail(String email);
    boolean existsPersonWithId(Integer customerId);
    void deleteCustomerById(Integer id);
    void customerUpdate(Customer customer);

}
