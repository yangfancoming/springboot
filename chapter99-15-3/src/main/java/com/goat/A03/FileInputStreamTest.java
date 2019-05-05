package com.goat.A03;


import org.junit.Test;

import java.io.*;

/**
 E:\Code\J2EE_code\MySpringBoot\springboot\chapter99-15-3\src\main\resources\copy01.txt
*/

public class FileInputStreamTest {

    String path1 = " E:\\Code\\J2EE_code\\MySpringBoot\\springboot\\chapter99-15-3\\src\\main\\resources\\copy01.txt";
    String path2 = " E:\\Code\\J2EE_code\\MySpringBoot\\springboot\\chapter99-15-3\\src\\main\\resources\\copy02.txt";

    @Test
    public void test() throws IOException {
        // 创建字节输入流
        FileInputStream fis = new FileInputStream("E:\\Code\\J2EE_code\\MySpringBoot\\springboot\\chapter99-15-3\\src\\main\\java\\com\\goat\\A03\\FileOutputStreamTest.java");
        byte[] bbuf = new byte[1024]; // 创建一个长度为1024的“竹筒”
        int hasRead ;  // 用于保存实际读取的字节数
        // 使用循环来重复“取水”过程
        while ((hasRead = fis.read(bbuf)) > 0) {
            System.out.print(new String(bbuf, 0, hasRead));// 取出“竹筒”中水滴（字节），将字节数组转换成字符串输入！
        }
        fis.close();  // 关闭文件输入流，放在finally块里更安全
    }

    @Test
    public void test1() throws IOException {
        FileInputStream fis = new FileInputStream(path1);
        FileOutputStream fos = new FileOutputStream(path2);
        int n;
        while((n = fis.read()) != -1){ //这里面是n等于读取到的字节数，当读取到末尾时，返回的是-1，所以这里用！=-1来表示没有读到文件末尾
            fos.write(n);
        }
        fos.close();
        fis.close();
    }
}
