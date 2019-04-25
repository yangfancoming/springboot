package com.goat.bean2;

/**
 * Created by 64274 on 2019/2/23.
 *
 * @ Description: 基于 xml 配置
 * @ author  山羊来了
 * @ date 2019/2/23---19:42
 */
public class Dog {

    private String lastName;
    private Integer age;

    public Dog() {
        System.out.println("构造函数 Dog(无参数)执行");
    }

    public Dog(String lastName, Integer age) {
        this.lastName = lastName;
        this.age = age;
        System.out.println("构造函数 Dog(有参数)执行");
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
