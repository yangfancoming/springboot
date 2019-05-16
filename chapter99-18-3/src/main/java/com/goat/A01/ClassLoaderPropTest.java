package com.goat.A01;

import java.io.IOException;
import java.net.URL;
import java.util.Enumeration;

/**
 * Created by 64274 on 2019/5/16.
 *
 * @ Description: TODO
 * @ author  山羊来了
 * @ date 2019/5/16---9:17
 */
public class ClassLoaderPropTest {
    public static void main(String[] args) throws IOException{

        // 获取系统类加载器
        ClassLoader systemLoader = ClassLoader.getSystemClassLoader();
        System.out.println("系统类加载器：" + systemLoader);
		/*
		获取系统类加载器的加载路径——通常由CLASSPATH环境变量指定
		如果操作系统没有指定CLASSPATH环境变量，默认以当前路径作为系统类加载器的加载路径
		*/
        Enumeration<URL> em1 = systemLoader.getResources("");
        while(em1.hasMoreElements()){
            System.out.println(em1.nextElement());
        }
        // 获取系统类加载器的父类加载器：得到扩展类加载器
        ClassLoader extensionLader = systemLoader.getParent();
        System.out.println("扩展类加载器：" + extensionLader);
        System.out.println("扩展类加载器的加载路径：" + System.getProperty("java.ext.dirs"));
        System.out.println("扩展类加载器的parent: "  + extensionLader.getParent());

    }
}
