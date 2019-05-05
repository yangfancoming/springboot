package com.goat.A03;

import org.junit.Test;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.FileInputStream;
import java.io.FileOutputStream;

/**
 * Created by 64274 on 2019/5/5.
 * @ Description: TODO
 * @ author  山羊来了
 * @ date 2019/5/5---17:49
 */
public class BufferedInputStreamTest {

    String path = "E:\\Code\\J2EE_code\\MySpringBoot\\springboot\\chapter99-15-3\\src\\main\\resources\\";

    @Test
    public void t2() throws Exception{ // ①利用缓冲流进行拷贝，一个一个字节拷贝
        BufferedInputStream bis = new BufferedInputStream(new FileInputStream(path + "demo.avi"),2*1024);
        BufferedOutputStream bos = new BufferedOutputStream(new FileOutputStream(path + "copy2.avi"),2*1024);
        int len;
        while((len = bis.read()) != -1){
            bos.write(len);
        }
        bos.close();
        bis.close();
    }

    @Test
    public void t1() throws Exception{ // ②利用缓冲流进行拷贝，多个字节多个字节拷贝
        BufferedInputStream bis = new BufferedInputStream(new FileInputStream(path + "copy01.txt"));
        BufferedOutputStream bos = new BufferedOutputStream(new FileOutputStream(path + "copy02.txt"));
        byte[] b = new byte[2*1024];
        int len;
        while((len = bis.read(b)) != -1){
            bos.write(b, 0, len);
        }
        bos.close();
        bis.close();
    }

    @Test
    public void t3() throws Exception{ // ③利用缓冲流实现对文件的追加
        BufferedOutputStream bos = new BufferedOutputStream(new FileOutputStream(path + "hello.txt",true));
        bos.write("sadadas".getBytes());
        bos.close();
    }

    @Test
    public void t5() throws Exception{ // ④利用缓冲流读取文件
        FileInputStream fis = new FileInputStream(path + "hello.txt");
        int len;
        while((len = fis.read()) != -1){
            System.out.print((char)len);
        }
        fis.close();
    }


}
