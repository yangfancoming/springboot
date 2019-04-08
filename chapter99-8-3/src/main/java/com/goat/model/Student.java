package com.goat.model;

/**
 * Created by 64274 on 2019/4/8.
 *
 * @ Description: TODO
 * @ author  山羊来了
 * @ date 2019/4/8---15:38
 */
public class Student implements Comparable<Student> {
    private int id;
    private int age;
    private String name;

    public Student(int id, int age, String name) {
        this.id = id;
        this.age = age;
        this.name = name;
    }
    @Override
    public int compareTo(Student o) {
        //降序
        //return o.age - this.age;
        //升序
        return this.age - o.age;
    }

    @Override
    public String toString() {
        return "Student{" + "id=" + id + ", age=" + age + ", name='" + name + '\'' + '}';
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
