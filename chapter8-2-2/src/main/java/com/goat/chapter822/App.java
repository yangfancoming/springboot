package com.goat.chapter822;

import io.minio.MinioClient;
import io.minio.errors.InvalidEndpointException;
import io.minio.errors.InvalidPortException;
import org.junit.Test;

/**
 * Created by Administrator on 2020/1/10.
 *
 * @ Description: TODO
 * @ author  山羊来了
 * @ date 2020/1/10---12:59
 */
public class App {

    public App() throws InvalidPortException, InvalidEndpointException {}

    MinioClient minioClient = new MinioClient("http://192.168.211.128:9000", "minioadmin", "minioadmin");

    @Test
    public void add() {
        try {
            // 检查文件夹是否已经存在
            boolean isExist = minioClient.bucketExists("managertest");
            if(isExist)  return;
            // 创建一个名为managertest的文件夹
            minioClient.makeBucket("managertest");
            // 使用putObject上传一个文件到文件夹中。
            //参数为：文件夹，要存成的名字，要存的文件
            minioClient.putObject("managertest","1.png", "D:\\123\\12.txt");
        } catch (Exception e) {
            System.out.println("错误: " + e);
        }
    }

    @Test
    public void get()  {
        try {
            //使用getObject获取一个文件
            // 调用statObject()来判断对象是否存在。
            minioClient.statObject("managertest", "2.png");
            // 获取1.png的流并保存到photo.png文件中。
            //参数为：文件夹，要获得的文件，要写入的文件
            minioClient.getObject("managertest", "1.png", "D:\\123\\22.txt");
        } catch (Exception e) {
            System.out.println("错误: " + e);
        }
    }
}
