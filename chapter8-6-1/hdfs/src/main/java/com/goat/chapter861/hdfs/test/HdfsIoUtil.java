package com.goat.chapter861.hdfs.test;

import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.fs.FSDataOutputStream;
import org.apache.hadoop.fs.FileSystem;
import org.apache.hadoop.fs.Path;
import org.apache.hadoop.io.IOUtils;
import org.junit.Test;

import java.io.File;
import java.io.FileInputStream;
import java.net.URI;

/**
 * Created by Administrator on 2020/3/11.
 *
 * @ Description: TODO
 * @ author  山羊来了
 * @ date 2020/3/11---13:58
 */
public class HdfsIoUtil {

    Configuration conf = new Configuration();
    // 把本地 D:\123\123.txt 文件上传到HDFS根目录
    @Test
    public void test() throws Exception{
        // 1 获取对象
        FileSystem fs = FileSystem.get(new URI("hdfs://192.168.211.128:9000"), conf, "atguigu");
        // 2 获取输入流
        FileInputStream fis = new FileInputStream(new File("D:\\123\\123.txt"));
        // 3 获取输出流
        FSDataOutputStream fos = fs.create(new Path("/123.txt"));
        // 4 流的对拷
        IOUtils.copyBytes(fis, fos, conf);
        // 5 关闭资源
        IOUtils.closeStream(fos);
        fs.close();
    }
}
