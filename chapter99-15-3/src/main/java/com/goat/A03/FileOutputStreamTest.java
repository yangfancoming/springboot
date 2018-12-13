package com.goat.A03;

import org.testng.annotations.Test;

import java.io.*;

public class FileOutputStreamTest {

    @Test
    public void test(){
        // 这个括号在JDK1.7之前是没有的，是1.7的新特性，括号里的内容支持包括流以及任何可关闭的资源，数据流会在 try 执行完毕后自动被关闭，而不用我们手动关闭了
        try (
                // 创建字节输入流
                FileInputStream fis = new FileInputStream("E:\\Code\\J2EE_code\\MySpringBoot\\springboot\\chapter99-15-3\\src\\main\\java\\com\\goat\\A03\\FileOutputStreamTest.java");
                // 创建字节输出流
                FileOutputStream fos = new FileOutputStream("newFile.txt"))
        {
            byte[] bbuf = new byte[32];
            int hasRead ;
            // 循环从输入流中取出数据
            while ((hasRead = fis.read(bbuf)) > 0) {
                // 每读取一次，即写入文件输出流，读了多少，就写多少。
                fos.write(bbuf, 0, hasRead);
            }
        } catch (IOException ioe) {
            ioe.printStackTrace();
        }
    }

}
