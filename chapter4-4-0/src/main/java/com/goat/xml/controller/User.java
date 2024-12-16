package com.goat.xml.controller;


import javax.xml.bind.annotation.XmlRootElement;


/**
 * Created by 64274 on 2024/12/9.
 *
 * @ Description: TODO
 * @ author  山羊来了
 * @ date 2024/12/9---9:16
 */

@XmlRootElement
public class User {
    // Fields and methods

    String name;
    int age;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }
}