package com.goat.model;

/**
 * Created by Administrator on 2019/12/5.
 *
 * @ Description: TODO
 * @ author  山羊来了
 * @ date 2019/12/5---15:43
 */
public class Person implements Eagle, Whale {

    private int id = 10001;

    public void Speak(String name){
        System.out.println("我的名字"+name+" "+ "编号"+ id);
    }

    @Override
    public void fly() {
        System.out.println("I can Fly!!!");
    }

    @Override
    public void swim() {
        System.out.println("I can swimming!!!");
    }
}