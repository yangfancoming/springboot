package com.goat.jar.model;

/**
 * Created by 64274 on 2019/2/14.
 *
 * @ Description: TODO
 * @ author  山羊来了
 * @ date 2019/2/14---11:12
 */
public class User {

    Long id;
    String name;

    public User() {
    }

    public User(Long id, String name) {
        this.id = id;
        this.name = name;
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
}
