package com.goat.condition;

/**
 * Created by 64274 on 2019/2/16.
 *
 * @ Description: TODO
 * @ author  山羊来了
 * @ date 2019/2/16---10:35
 */
public class Person {

    String name;
    Integer age;

    public Person() {
    }

    public Person(String name, Integer age) {
        this.name = name;
        this.age = age;
    }

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
