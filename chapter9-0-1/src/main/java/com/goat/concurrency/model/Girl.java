package com.goat.concurrency.model;

/**
 * Created by 64274 on 2019/4/21.
 *
 * @ Description: TODO
 * @ author  山羊来了
 * @ date 2019/4/21---23:14
 */
public class Girl {

    String name;
    int age;

    public Girl(String name, int age) {
        this.name = name;
        this.age = age;
    }

    @Override
    public String toString() {
        return "Girl{" + "name='" + name + '\'' + ", age=" + age + '}';
    }
}
