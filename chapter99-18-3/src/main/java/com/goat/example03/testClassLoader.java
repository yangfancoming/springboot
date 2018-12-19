package com.goat.example03;

/**
 * Created by 64274 on 2018/7/30.
 *
 * @author 山羊来了
 * @Description: TODO
 * @date 2018/7/30---21:12
 */
public class testClassLoader {
    public static void main(String[] args) {
        ClassLoader loader = Thread.currentThread().getContextClassLoader();
        System.out.println(loader); //AppClassLoader
        System.out.println(loader.getParent()); // ExtClassLoader
        System.out.println(loader.getParent().getParent()); // null
    }
}
