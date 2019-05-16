package com.goat.A01;


import java.net.URL;

/**
 * Created by 64274 on 2018/7/27.
 *
 */
public class TestNG {


    public static void main(String[] args) {
        // 获取根类加载器所加载的全部URL数组
        URL[] urls = sun.misc.Launcher.getBootstrapClassPath().getURLs();
        // 遍历、输出根类加载器加载的全部URL
        for (int i = 0; i < urls.length; i++){
            System.out.println(urls[i].toExternalForm());
        }
    }


}
