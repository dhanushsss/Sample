package com.dhanushs.customer.service;

import com.dhanushs.customer.model.CustomerDao;
import com.dhanushs.customer.registration.CustomerRegistration;
import com.dhanushs.customer.model.Customer;
import com.dhanushs.exception.DuplicateResourceException;
import com.dhanushs.exception.RequestValidation;
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
                throw new DuplicateResourceException("Email Already Taken");
            }

            Customer customer = new Customer(
                    customerRegistration.name() ,
                    customerRegistration.email(),
                    customerRegistration.age());

            customerDao.getCustomer(customer);
    }

    public void deleteCustomerById(Integer customerId ){

        if(!customerDao.existsPersonWithId(customerId)){
            throw new ResourceNotFundException("Customer id [%s] is not found".formatted(customerId));
        }
        customerDao.deleteCustomerById(customerId);
    }

    public void updateCustomerDetails(Integer customerId , CustomerRegistration customerRegistration){

        Customer customer =  getCustomer(customerId);

        boolean changes = false ;

        if(customerRegistration.name() != null && !customerRegistration.name().equals(customer.getName())){
            customer.setName(customerRegistration.name());
            changes = true;
        }
        if (customerRegistration.email() != null && !customerRegistration.email().equals(customer.getEmail())){

            if(customerDao.existsPersonWithEmail(customerRegistration.email())){
                throw new DuplicateResourceException("email is already taken");
            }
            customer.setEmail(customerRegistration.email());
            changes = true;
            if (!changes){
                throw new RequestValidation("no data has been changed");
            }
        }
        if (customerRegistration.age() != null && !customerRegistration.age().equals(customer.getAge())){
            customer.setAge(customerRegistration.age());
            changes = true;
        }

        customerDao.customerUpdate(customer);


    }
}