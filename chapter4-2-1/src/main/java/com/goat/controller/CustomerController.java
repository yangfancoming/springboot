package com.goat.controller;

import com.goat.domain.Customer;
import com.goat.repository.CustomerRepository;

import java.util.List;

@Controller
@RequestMapping("/customer")
public class CustomerController {

    @Autowired
    CustomerRepository customerRepository;

    @RequestMapping("/allCustomer")
    public void test(){
        List<Customer> customers = customerRepository.findDistinctByLastName("");
    }

}
