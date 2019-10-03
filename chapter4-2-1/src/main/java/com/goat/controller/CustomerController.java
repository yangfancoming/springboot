package com.goat.controller;

import com.goat.domain.Customer;
import com.goat.repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * Created by 64274 on 2019/3/6.
 *
 * @ Description: TODO
 * @ author  山羊来了
 * @ date 2019/3/6---14:39
 */
@RestController
@RequestMapping("/customer")
public class CustomerController {

    @Autowired
    CustomerRepository customerRepository;

    //  http://localhost:8421/customer/test1
    @GetMapping("/test1")
    public List<Customer> findDistinctByFirstName(){
        List<Customer> list = customerRepository.queryDistinctByFirstName("");
        return list;
    }
}
