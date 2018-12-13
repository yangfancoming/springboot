package com.goat.A03;

import org.testng.annotations.Test;

import java.io.*;


public class FileInputStreamTest {
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
}
