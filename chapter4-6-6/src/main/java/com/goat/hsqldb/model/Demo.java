package com.goat.hsqldb.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

/**
 * Created by 64274 on 2019/7/4.
 *
 * @ Description: TODO
 * @ author  山羊来了
 * @ date 2019/7/4---18:04
 */
@Entity
public class Demo {
    @Id
    @GeneratedValue
    private Long id;
    private String name;
    private int age;

    public Demo() {
    }

    public Demo(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }
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

