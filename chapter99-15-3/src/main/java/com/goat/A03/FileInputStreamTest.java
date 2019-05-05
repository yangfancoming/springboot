package com.goat.A03;


import org.junit.Test;

import java.io.*;

/**
 E:\Code\J2EE_code\MySpringBoot\springboot\chapter99-15-3\src\main\resources\copy01.txt
*/

public class FileInputStreamTest {

    String path = "E:\\Code\\J2EE_code\\MySpringBoot\\springboot\\chapter99-15-3\\src\\main\\resources\\";

    @Test
    public void test() throws IOException { // ①拷贝文件，一个一个字节的拷贝
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
        FileInputStream fis = new FileInputStream(path + "copy01.txt");
        FileOutputStream fos = new FileOutputStream(path + "copy02.txt");
        int n;
        while((n = fis.read()) != -1){ //这里面是n等于读取到的字节数，当读取到末尾时，返回的是-1，所以这里用！=-1来表示没有读到文件末尾
            fos.write(n);
        }
        fos.close();
        fis.close();
    }

    @Test
    public void test2() throws IOException { // ②拷贝视屏：1024个字节1024个字节的拷贝
        FileInputStream fis = new FileInputStream(path + "demo.avi");
        FileOutputStream fos = new FileOutputStream(path + "copy.avi");
        byte[] n = new byte[1024];
        int len;
        //这里是1024个字节的读取，所以在read（）里面放的是每次读取的字节数
        while((len = fis.read(n)) != -1){
            fos.write(n, 0, len);
        }
        fos.close();
        fis.close();
    }

    @Test
    public void test3() throws IOException {
//        FileOutputStream fos = new FileOutputStream(path + "hello.txt"); // ③利用FileOutputStream将数据写入文件 覆盖文件原有内容
        FileOutputStream fos = new FileOutputStream(path + "hello.txt",true); // ④实现对文件内容的追加，即不会覆盖掉原来的内容，在末尾继续添加
        fos.write(98);//这里写入的是ASCII码
        //注意这里的getBytes（），这个是String类里面的方法，使用平台的默认字符集将此 String 编码为 byte 序列，并将结果存储到一个新的 byte 数组中
        fos.write("sadsadsada".getBytes());
        fos.close();
    }
}
