package com.goat.chapter206;

import com.goat.chapter206.config.HdfsConfig;
import com.goat.chapter206.util.HdfsUtil;
import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.fs.FileSystem;
import org.apache.hadoop.fs.Path;
import org.junit.Test;

import java.net.URI;

/**
 * Created by Administrator on 2020/3/10.
 *
 * @ Description: TODO
 * @ author  山羊来了
 * @ date 2020/3/10---13:44
 */
public class App {

    @Test
    public void test(){
        HdfsConfig config = new HdfsConfig("192.168.211.128", "9000", "root");
        String destination = "D:\\123\\FUCK.txt"; // windows 文件
        String source  = "/hadoop/12.txt"; //centos7 hdfs 文件存储地址
        HdfsUtil.download(config, source, destination);
    }

    @Test
    public void test2(){
        HdfsConfig config = new HdfsConfig("192.168.211.128", "9000", "root");
        String source = "D:\\123\\12.txt"; // windows 文件
        String destination = "/hadoop/12.txt"; //centos7 hdfs 文件存储地址
        HdfsUtil.upload(config, source, destination);
    }

    @Test
    public void test3() throws Exception {
        Configuration conf = new Configuration();
        FileSystem fileSystem = FileSystem.get(new URI("hdfs://hadoop-master:9000"), conf, "root");
        Path path = new Path("/hdfsapi/test");
        boolean mkdirs = fileSystem.mkdirs(path);
        System.out.println(mkdirs);
        System.out.println("运行结束");
    }
}
