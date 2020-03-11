package com.goat.chapter861.hdfs.test;

import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.fs.*;
import org.junit.After;
import org.junit.Test;

import java.io.IOException;
import java.net.URI;

/**
 * Created by Administrator on 2020/3/11.
 * @ Description: TODO
 * @ author  山羊来了
 * @ date 2020/3/11---10:42
 */
public class HDFSClientApp {

    Configuration conf = new Configuration();
    FileSystem fs;

    // 获取客户端方式一
    @Test
    public void client1() throws Exception{
        conf.set("fs.defaultFS", "hdfs://192.168.211.128:9000");
        fs = FileSystem.get(conf);
        System.out.println( mkdir(fs, "/0527/dashen/banzhang"));
    }

    // 获取客户端方式二
    @Test
    public void client2() throws Exception{
        fs = FileSystem.get(new URI("hdfs://192.168.211.128:9000"), conf, "atguigu");
        System.out.println(mkdir(fs, "/0528/dashen/banzhang"));
    }

    /**
     * 删除文件夹
     *  "/0528/dashen/banzhang" 只删除最下级 banzhang
     *  "/0528"  删除/0528及其以下所有子目录
    */
    @Test
    public void delete() throws Exception{
        fs = FileSystem.get(new URI("hdfs://192.168.211.128:9000"), conf, "atguigu");
        boolean delete = fs.delete(new Path("/xiaohua1.txt"), true);
        System.out.println(delete);
    }

    // 文件上传
    @Test
    public void upload() throws Exception{
        // 设置文件上传优先级
        conf.set("dfs.replication", "2");
        fs = FileSystem.get(new URI("hdfs://192.168.211.128:9000"), conf, "atguigu");
        fs.copyFromLocalFile(new Path("D:\\123\\12.txt"), new Path("/xiaohua1.txt"));
    }

    // 文件下载
    @Test
    public void down() throws Exception{
        fs = FileSystem.get(new URI("hdfs://192.168.211.128:9000"), conf, "atguigu");
        fs.copyToLocalFile(false, new Path("/xiaohua.txt"), new Path("D:\\123\\fuck.txt"), true);
    }

    // 文件改名
    @Test
    public void rename() throws Exception{
        fs = FileSystem.get(new URI("hdfs://192.168.211.128:9000"), conf, "atguigu");
        fs.rename(new Path("/xiaohua1.txt"), new Path("/xiaohua3.txt"));
    }

    // 文件详情
    @Test
    public void listFiles() throws Exception{
        fs = FileSystem.get(new URI("hdfs://192.168.211.128:9000"), conf, "atguigu");
        // 2 查看文件详情
        RemoteIterator<LocatedFileStatus> listFiles = fs.listFiles(new Path("/"), true);
        while(listFiles.hasNext()){
            LocatedFileStatus fileStatus = listFiles.next();
            // 查看文件名称、权限、长度、块信息
            System.out.println("文件名称" + fileStatus.getPath().getName());// 文件名称
            System.out.println("权限" + fileStatus.getPermission());// 文件权限
            System.out.println("长度" + fileStatus.getLen());// 文件长度
            BlockLocation[] blockLocations = fileStatus.getBlockLocations();
            for (BlockLocation blockLocation : blockLocations) {
                String[] hosts = blockLocation.getHosts();
                for (String host : hosts) {
                    System.out.println(host);
                }
            }
            System.out.println("------班长分割线--------");
        }
    }

    // 判断文件还是文件夹
    @Test
    public void isFile() throws Exception{
        fs = FileSystem.get(new URI("hdfs://192.168.211.128:9000"), conf, "atguigu");
        FileStatus[] listStatus = fs.listStatus(new Path("/"));
        for (FileStatus fileStatus : listStatus) {
            String type = fileStatus.isFile()?"文件":"文件夹";
            System.out.println(type + fileStatus.getPath().getName());
        }
    }

    // 在hdfs上创建 文件夹
    public boolean mkdir(FileSystem fs,String dir) throws IOException {
        boolean mkdirs = fs.mkdirs(new Path(dir));
        return mkdirs;
    }

    @After
    public void after() throws IOException {
        fs.close();
        System.out.println("关闭资源");
    }

}
