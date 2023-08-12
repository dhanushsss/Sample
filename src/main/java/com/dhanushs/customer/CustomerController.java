package com.dhanushs.customer;

import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("api/v1/customers")
public class CustomerController {

    private final CustomerService customerService ;

    public CustomerController(CustomerService customerService) {
        this.customerService = customerService;
    }

    @RequestMapping( method = RequestMethod.GET)
    /*
    @GetMapping("api/v1/customers")
    */
    public List<Customer> getCustomer(){
        return customerService.getAllCustomers();
    }
    @GetMapping("{customerId}")
    public Customer getCustomerById(@PathVariable("customerId") Integer customerId){
        return customerService.getCustomer(customerId);
    }

    @PostMapping
    public void registerCustomer(@RequestBody CustomerRegistration customerRegistration){
        customerService.addCustomer(customerRegistration);
    }

    @DeleteMapping("{customerId}")
    public void deleteCustomerById(@PathVariable("customerId") Integer customerId){
        customerService.deleteCustomerById(customerId);
    }

    @PutMapping
    public void updateCustomerDetail(
            @PathVariable ("customerId") Integer customerId ,
            @RequestBody CustomerRegistration customerRegistration){
        customerService.updateCustomerDetails(customerId,customerRegistration);
    }


}
