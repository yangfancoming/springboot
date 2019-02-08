package com.goat.entity;

import org.springframework.data.annotation.Id;

import java.io.Serializable;

/**
 * 客户实体类
 */
public class Customer implements Serializable {

    /** 客户编号 */
    @Id
    public String id;

    /** 客户名称 */
    public String firstName;

    /** 客户姓氏 */
    public String lastName;

    public Customer(String firstName, String lastName) {
        this.firstName = firstName;
        this.lastName = lastName;
    }
}
