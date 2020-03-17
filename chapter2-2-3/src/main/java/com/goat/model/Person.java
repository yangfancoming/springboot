package com.goat.model;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.goat.config.PersonDeserializer;
import com.goat.config.PersonSerializer;

import java.io.Serializable;

/**
 * Created by Administrator on 2020/3/17.
 *
 * @ Description: TODO
 * @ author  山羊来了
 * @ date 2020/3/17---11:27
 */

@JsonSerialize(using = PersonSerializer.class)
@JsonDeserialize(using = PersonDeserializer.class)
public class Person implements Serializable {

    private String userName;

    private int age;

    public Person() {
    }

    public Person(String userName, int age) {
        this.userName = userName;
        this.age = age;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }
}
