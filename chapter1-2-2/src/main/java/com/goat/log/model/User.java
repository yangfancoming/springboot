package com.goat.log.model;

/**
 * Created by Administrator on 2019/12/3.
 *
 * @ Description: TODO
 * @ author  山羊来了
 * @ date 2019/12/3---18:44
 */
public class User {

    public User() {
    }

    public User(String name, Integer age) {
        this.name = name;
        this.age = age;
    }

    private String name;
    private Integer age;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }
}
