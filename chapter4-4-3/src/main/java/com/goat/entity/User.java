package com.goat.entity;


import org.apache.ibatis.type.Alias;


@Alias("haha") //<!--还可以使用注解 @Alias("haha") 的方式  但是被注解的类 必须是在 批量别名指定的包下！-->
public class User {
    private String id;
    private String name;

    public User(){

    }
    public User(String id, String name){
        this.id = id;
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