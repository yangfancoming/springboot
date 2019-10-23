package com.goat.chapter118.model;

/**
 * Created by 64274 on 2019/10/23.
 *
 * @ Description: TODO
 * @ author  山羊来了
 * @ date 2019/10/23---18:40
 */

public class Student {

    private String name;

    private int age;

    private double height;

    public Student() {
        super();
    }

    public Student(String name, int age, double height) {
        super();
        this.name = name;
        this.age = age;
        this.height = height;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public double getHeight() {
        return height;
    }

    public void setHeight(double height) {
        this.height = height;
    }

    @Override
    public String toString() {
        return "Student [name=" + name + ", age=" + age + ", height=" + height + "]";
    }
}

