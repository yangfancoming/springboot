package com.goat.model;

/**
 * Created by 64274 on 2018/7/20.
 *
 * @author 山羊来了
 * @Description: TODO
 * @date 2018/7/20---18:54
 */
public class Dog {

    /*成员属性*/
    private String name;
    Integer age;
    public boolean married;
    public String nickName;

    /*构造方法*/
    public Dog() {
    }
    /*构造方法*/
    public Dog(String name, Integer age) {
        this.name = name;
        this.age = age;
    }

    /*成员方法*/
    private void fuck(){
        System.out.println("fuck!!!!!!!!!hahaha");
    }

    private void shit(String name, Integer age){
        System.out.println("shit!!!!!!!!!hahaha" + name + age);
    }

    public void eat1(){
        System.out.println("eat!!!!!!!!!hahaha");
    }

    public void eat2(String name){
        System.out.println("eat!!!!!!!!!hahaha" + name);
    }

    /* getter/setter 方法 */
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

    public String getNickName() {
        return nickName;
    }

    public void setNickName(String nickName) {
        this.nickName = nickName;
    }

    @Override
    public String toString() {
        return "Dog{" + "name='" + name + '\'' + ", age=" + age + ", married=" + married + ", nickName='" + nickName + '\'' + '}';
    }
}
