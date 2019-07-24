package com.goat.A06.item04;


import org.junit.Test;

import java.util.*;
import java.io.*;
/**
 * Description:
 * 是Hashtable 的子类,还可以从xml中获取。
 */
public class PropertiesTest {

    Properties props = new Properties();

    /**  输出流  java对象 存入 文件中
     　 将 props 中的key-value对保存到a.ini文件中
     保存后的属性文件第一行会是#comments,表示注释信息；如果为空则没有注释信息
     */
    @Test
    public void out() throws IOException {
		// 向Properties中增加属性
		props.setProperty("username" , "goat");
		props.setProperty("password" , "12345");
        FileOutputStream outputStream = new FileOutputStream("a.ini");
        props.store(outputStream, "哎呀我去");
        outputStream.close();
	}

    /**  输入流  文件 存入 java对象中
     　这个方法可以从.properties 属性文件对应的文件输入流中，加载属性列表到 Properties 类对象
    */
    @Test
    public void in() throws IOException {
        props.setProperty("gender" , "male");
        FileInputStream inputStream = new FileInputStream("a.ini");
        props.load(inputStream);
        inputStream.close();
        System.out.println(props);
        System.out.println(props.getProperty("gender"));
    }
}
