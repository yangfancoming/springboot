package com.goat.entity;

import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "students") // 将 实体类 与 mongoDB 中的 集合 进行绑定
public class Student {
    private String id;
    private String name;
    private Integer age;
    private String gender;

    public Student(){

    }
    public Student(String id, String name){
        this.id = id;
        this.name = name;
    }

    public Student(String name, Integer age, String gender) {
        this.name = name;
        this.age = age;
        this.gender = gender;
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

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    @Override
    public String toString() {
        return "Student{" + "id='" + id + '\'' + ", name='" + name + '\'' + ", age=" + age + ", gender='" + gender + '\'' + '}';
    }
}