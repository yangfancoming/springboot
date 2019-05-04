package com.goat.A03;


import org.junit.Test;

import java.io.*;


public class FileReaderTest {

    @Test
    public void test(){
        File file = new File("hello.txt");// 相较于当前Module
        try (FileReader fr = new FileReader(file)) {
            char[] cbuf = new char[32];   // 创建一个长度为32的“竹筒”
            int hasRead;   // 用于保存实际读取的字符数
            while (  (hasRead = fr.read(cbuf)) > 0  ) {   // 使用循环来重复“取水”过程
                System.out.print(new String(cbuf, 0, hasRead)); // 取出“竹筒”中水滴（字符），将字符数组转换成字符串输入！
            }
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }

}
