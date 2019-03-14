package com.goat.model;

/**
 * Created by 64274 on 2019/3/14.
 *
 * @ Description: TODO
 * @ author  山羊来了
 * @ date 2019/3/14---14:52
 */
public class Foo {

    public Foo() {
    }

    public Foo(String name, Integer age) {
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
