package com.goat.model;

/**
 * Created by 64274 on 2019/2/12.
 *
 * @ Description: TODO
 * @ author  山羊来了
 * @ date 2019/2/12---19:45
 */
public class User {
    Integer age;
    String username;

    public User(Integer age, String username) {
        this.age = age;
        this.username = username;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }
}
