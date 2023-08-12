package com.dhanushs.customer;

import com.dhanushs.exception.DuplicateResourceException;
import com.dhanushs.exception.ResourceNotFoundException;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CustomerService {


    private final CustomerDao customerDao ;

    public CustomerService(@Qualifier("jpa") CustomerDao customerDao) {
        this.customerDao = customerDao;
    }

    public List<Customer> getAllCustomers(){
        return customerDao.selectAllCustomer();
    }


    public Customer getCustomer(Integer id){
        return customerDao.selectCustomerById(id)
                .orElseThrow(
                        ()->
                                new ResourceNotFoundException("Customer with ID [%s] is not found"
                                        .formatted(id))
                );
    }

    public void addCustomer(CustomerRegistration customerRegistration){

            String email = customerRegistration.email();
            if(customerDao.existsPersonWithEmail(email)){
                throw new DuplicateResourceException("" +
                        "Email Already Taken ");
            }


            Customer customer = new Customer(
                    customerRegistration.name() ,
                    customerRegistration.email(),
                    customerRegistration.age());


            customerDao.getCustomer(customer);

    }

}
