package com.goat.chapter453.entity;

import org.springframework.data.annotation.Id;

/**
 * Created by 64274 on 2018/8/23.
 * @author 山羊来了
 * @Description: TODO
 * @date 2018/8/23---17:21
 */
public class User {

    @Id
    private String id;
    private String name;

    public User() {
    }

    public User(String id, String name) {
        this.id = id;
        this.name = name;
    }

    public User(String name) {
        this.name = name;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "User{" + "id='" + id + '\'' + ", name='" + name + '\'' + '}';
    }
}