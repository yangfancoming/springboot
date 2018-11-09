package com.goat.domain;


import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

/**
 * Created by 64274 on 2018/9/28.
 * @author 山羊来了
 * @Description: TODO
 * @date 2018/9/28---17:12
 *
 * 如果省略 @Table 注解 则 表明默认为类名 Customer
 * @Id    主键 ID
 * @GeneratedValue 自动增长
 */


@Entity
public class Customer {

    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private Long id;
    private String firstName;
    private String lastName;

    protected Customer() {}

    public Customer(String firstName, String lastName) {
        this.firstName = firstName;
        this.lastName = lastName;
    }

    @Override
    public String toString() {
        return String.format("Customer[id=%d, firstName='%s', lastName='%s']",id, firstName, lastName);
    }

}