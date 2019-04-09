package com.goat.A03;


import org.junit.Test;

import java.io.*;


public class FileReaderTest {

    @Test
    public void test(){
        try (
                // 创建字符输入流
                FileReader fr = new FileReader("E:\\Code\\J2EE_code\\MySpringBoot\\springboot\\chapter99-15-3\\src\\main\\java\\com\\goat\\A03\\FileWriterTest.java")) {
            // 创建一个长度为32的“竹筒”
            char[] cbuf = new char[32];
            // 用于保存实际读取的字符数
            int hasRead = 0;
            // 使用循环来重复“取水”过程
            while ((hasRead = fr.read(cbuf)) > 0) {
                // 取出“竹筒”中水滴（字符），将字符数组转换成字符串输入！
                System.out.print(new String(cbuf, 0, hasRead));
            }
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }

}
