package com.goat.chapter206.util;

import com.goat.chapter206.config.HdfsConfig;
import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.fs.BlockLocation;
import org.apache.hadoop.fs.FileStatus;
import org.apache.hadoop.fs.FileSystem;
import org.apache.hadoop.fs.Path;
import org.apache.hadoop.io.IOUtils;

import java.io.*;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by Administrator on 2020/3/10.
 *
 * @ Description: TODO
 * @ author  山羊来了
 * @ date 2020/3/10---13:42
 */
public class HdfsUtil {


    public static void upload(HdfsConfig config, String source, String destination) {
        try {
            // 获得FileSystem对象，指定使用root用户上传
            FileSystem fileSystem = FileSystem.get(new URI(getHdfsUrl(config)), new Configuration(),config.getUsername());
            // 创建输入流，参数指定文件输出地址
            InputStream in = new FileInputStream(source);
            // 调用create方法指定文件上传，参数HDFS上传路径
            OutputStream out = fileSystem.create(new Path(destination));
            // 使用Hadoop提供的IOUtils，将in的内容copy到out，设置buffSize大小，是否关闭流设置true
            IOUtils.copyBytes(in, out, 4096, true);

        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (InterruptedException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (URISyntaxException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }

    public static void download(HdfsConfig config, String source, String destination) {
        try {
            // 获得FileSystem对象，指定使用root用户上传
            FileSystem fileSystem = FileSystem.get(new URI(getHdfsUrl(config)), new Configuration(),config.getUsername());
            // 调用open方法进行下载，参数HDFS路径
            InputStream in = fileSystem.open(new Path(source));
            // 创建输出流，参数指定文件输出地址
            OutputStream out = new FileOutputStream(destination);
            IOUtils.copyBytes(in, out, 4096, true);
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (InterruptedException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (URISyntaxException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }


    private static String getHdfsUrl(HdfsConfig config) {
        StringBuilder builder = new StringBuilder();
        builder.append("hdfs://").append(config.getHostname()).append(":").append(config.getPort());
        return builder.toString();
    }


}
