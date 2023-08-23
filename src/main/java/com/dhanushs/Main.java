package com.dhanushs;

import com.dhanushs.customer.model.Customer;
import com.dhanushs.customer.repository.CustomerRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.List;


@SpringBootApplication

public class Main {

    public static void main(String[] args) {

        /*
        CustomerService customerService
                = new CustomerService(new CustomerDataAccessService());

        CustomerController customerController
                = new CustomerController(customerService);

         */
        SpringApplication.run(Main.class,args);

    }

    @Bean
    CommandLineRunner runner(CustomerRepository  customerRepository){

        return args -> {

            Customer dhanush = new Customer(

                    "dhanush",
                    "sdhanushit@gmail.com",
                    22
            );

            Customer mohan = new Customer(

                    "mohan",
                    "mohanraj.sc@gmail.com",
                    22
            );
            Customer ellora = new Customer(

                    "ellora",
                    "ellora.suji@gmail.com",
                    23
            );

            List<Customer> customers = List.of(dhanush,ellora,mohan);
            customerRepository.saveAll(customers);

        };

    }

}
