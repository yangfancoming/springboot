package com.goat.controller;


import com.goat.domain.Customer;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;


@RestController
@RequestMapping("/entity")
public class EntityManagerController {

    @PersistenceContext
    private EntityManager entityManager;

    /*
    该方法 类似于 Hibernate 中的 get 方法
        Hibernate: select customer0_.id as id1_0_0_, customer0_.first_name as first_na2_0_0_, customer0_.last_name as last_nam3_0_0_ from customer customer0_ where customer0_.id=?
        -----------------------------
        Customer[id=1, firstName='123', lastName='3321']
     */
    //    http://localhost:8421/entity/test1
    @RequestMapping("/test1")
    public void find(){
        Customer customer = entityManager.find(Customer.class, 1L); // 执行 sql
        System.out.println("-----------------------------");
        System.out.println(customer);
    }

     /*
     该方法 类似于 Hibernate 中的 Load 方法  懒加载
        -----------------------------
        Hibernate: select customer0_.id as id1_0_0_, customer0_.first_name as first_na2_0_0_, customer0_.last_name as last_nam3_0_0_ from customer customer0_ where customer0_.id=?
        Customer[id=1, firstName='123', lastName='3321']
        该方法 只能在项目启动后进行测试，因为 在 junit 中测试 会报错： org.hibernate.LazyInitializationException: could not initialize proxy - no Session
     */
     //    http://localhost:8421/entity/test2
    @RequestMapping("/test2")
    public void getReference(){
        Customer customer = entityManager.getReference(Customer.class, 1L); // 返回代理对象
        System.out.println("-----------------------------");
        System.out.println(customer); // 执行 sql   懒加载  知道真正使用对象时  代理对象才执行sql ！！！
    }
    //    http://localhost:8421/entity/test3
    @RequestMapping("/test3")
    @Transactional
    public void persist(){
        Customer customer = new Customer("firstName","lastName");
        entityManager.persist(customer); // 没有设置 主键 id 可以正常插入
    }


    //    http://localhost:8421/entity/test4
    @RequestMapping("/test4")
    @Transactional
    public void persist2(){
        Customer customer = new Customer();
//        customer.setId(113L); // 设置 主键 id  则报错 org.hibernate.PersistentObjectException: detached entity passed to persist异常  是因为JPA注解指定了主键的生成策略主键，所以就不能设置了
        customer.setId(null);  //  设置 主键 id 为null或不显示set 则可以正常插入
        customer.setLastName("lasdf");
        customer.setFirstName("ddddd");
        entityManager.persist(customer);
    }

    //    http://localhost:8421/entity/test5
    @RequestMapping("/test5")
    @Transactional
    public void remove(){
        Customer customer = entityManager.find(Customer.class, 1L); // 执行 sql
        entityManager.remove(customer);
    }
}
