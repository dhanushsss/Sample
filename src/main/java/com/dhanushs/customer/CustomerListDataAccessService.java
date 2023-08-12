package com.dhanushs.customer;

import org.springframework.stereotype.Repository;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Repository("list")
public class CustomerListDataAccessService implements CustomerDao{


    private static List<Customer> customers ;

    static {

        customers = new ArrayList<>();

        Customer dhanush = new Customer(
                1,
                "dhanush",
                "sdhanushit@gmail.com",
                22
        );

        customers.add(dhanush);

        Customer mohan = new Customer(
                2,
                "mohan",
                "mohanraj.sc@gmail.com",
                22
        );

        customers.add(mohan);
        Customer ellora = new Customer(
                3,
                "ellora",
                "ellora.suji@gmail.com",
                23
        );

        customers.add(ellora);

    }

    @Override
    public List<Customer> selectAllCustomer() {
        return customers;
    }

    @Override
    public Optional<Customer> selectCustomerById(Integer customerId) {
        return customers.stream()
                .filter(customer -> customer.getId().equals(customerId))
                .findFirst();

    }

    @Override
    public void getCustomer(Customer customer) {
        customers.add(customer);
    }

    @Override
    public boolean existsPersonWithEmail(String email) {
        return customers.stream()
                .anyMatch(c->c.getEmail().equals(email));
    }

}
