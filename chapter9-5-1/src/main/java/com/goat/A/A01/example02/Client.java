package com.goat.A.A01.example02;

import java.io.IOException;

/**
 * 客户端：测试使用Api接口
 * 重要改变，没有new Impl()了，取而代之Factory.createApi()
 * 并且在工厂中 也没有new 了 而是使用 反射机制，从配置文件中读取 要创建的接口实现类，进行动态创建。
 */
public class Client {
    public static void main(String[] args) throws ClassNotFoundException, InstantiationException, IllegalAccessException, IOException {
        Api api = Factory.createApi();
        api.test1("123123");
    }
}
