//package com.goat.chapter861.hdfs.config;
//
//import org.apache.hadoop.fs.FileSystem;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//
//import java.net.URI;
//
///**
// * Created by Administrator on 2020/3/10.
// *
// * @ Description: TODO
// * @ author  山羊来了
// * @ date 2020/3/10---16:27
// */
////@Configuration
//public class HdfsConfig {
//
//    private static final String uri = "hdfs://192.168.211.128:9000";
//    private static final String USER = "hadoopUser";
//
////    @Bean
//    public FileSystem fileSystem() throws Exception {
////        //1.创建连接
////        org.apache.hadoop.conf.Configuration conf = new org.apache.hadoop.conf.Configuration();
////        conf.set("fs.defaultFS","hdfs://192.168.211.128:9000");
////        FileSystem fs = FileSystem.get(conf);
////        return fs;
//
//        org.apache.hadoop.conf.Configuration conf = new org.apache.hadoop.conf.Configuration();
//        FileSystem fs = FileSystem.get(new URI(uri), conf, USER);
//        return fs;
//    }
//}
