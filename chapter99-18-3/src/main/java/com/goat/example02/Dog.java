package com.goat.example02;

/**
 * Created by 64274 on 2018/7/20.
 *
 * @author 山羊来了
 * @Description: TODO
 * @date 2018/7/20---18:54
 */
public class Dog {

    private String name;
    Integer age;
    public boolean married;

    public Dog() {
    }

    public Dog(String name, Integer age) {
        this.name = name;
        this.age = age;
    }

    private void fuck(){
        System.out.println("fuck!!!!!!!!!hahaha");
    }

    @Override
    public String toString() {
        return "Dog{" + "name='" + name + '\'' + ", age=" + age + '}';
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
