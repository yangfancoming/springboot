package com.goat.controller;


import com.goat.domain.Customer;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;


@RestController
@RequestMapping("/hello")
public class EntityManagerController {

    @PersistenceContext
    private EntityManager entityManager;

    /*
        Hibernate: select customer0_.id as id1_0_0_, customer0_.first_name as first_na2_0_0_, customer0_.last_name as last_nam3_0_0_ from customer customer0_ where customer0_.id=?
        -----------------------------
        Customer[id=1, firstName='123', lastName='3321']
     */
    //    http://localhost:8421/hello/test1
    @RequestMapping("/test1")
    public void test1(){
        Customer customer = entityManager.find(Customer.class, 1L);
        System.out.println("-----------------------------");
        System.out.println(customer);
    }

     /*
        -----------------------------
        Hibernate: select customer0_.id as id1_0_0_, customer0_.first_name as first_na2_0_0_, customer0_.last_name as last_nam3_0_0_ from customer customer0_ where customer0_.id=?
        Customer[id=1, firstName='123', lastName='3321']
     */
     //    http://localhost:8421/hello/test2
    @RequestMapping("/test2")
    public void test2(){
        Customer customer = entityManager.getReference(Customer.class, 1L);
        System.out.println("-----------------------------");
        System.out.println(customer);
    }
}
