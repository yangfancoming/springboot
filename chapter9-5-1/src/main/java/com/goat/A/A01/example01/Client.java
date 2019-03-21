package com.goat.A.A01.example01;
/**
 * 客户端，使用Api接口
 * 通过简单工厂来获取接口对象 ， 但是这种方式  还是存在弊端： 工厂类和 接口实现类存在强耦合 因为 实现类在工厂里 new了！
 * 并且 客户端 涉及到传参，那么就必须要知道参数的意义。。。 还是存储耦合
 */
public class Client {
    public static void main(String[] args) {
        Api api = Factory.createApi(2);
        api.operation("正在使用简单工厂");
    }
}
