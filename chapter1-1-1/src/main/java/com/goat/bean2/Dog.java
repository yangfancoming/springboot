package com.goat.bean2;

/**
 * Created by 64274 on 2019/2/23.
 *
 * @ Description: TODO
 * @ author  山羊来了
 * @ date 2019/2/23---19:42
 */
public class Dog {

    private String lastName;
    private Integer age;

    public Dog() {
    }

    public Dog(String lastName, Integer age) {
        this.lastName = lastName;
        this.age = age;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }
}
