package com.goat;


import com.aliyun.oss.OSSClient;
import com.aliyun.oss.model.ObjectMetadata;
import com.aliyun.oss.model.PutObjectResult;
import com.goat.config.AliyunOssConfig;
import com.goat.utils.OssUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.testng.AbstractTestNGSpringContextTests;
import org.testng.annotations.Test;

import java.io.File;


/**
 * Created by 64274 on 2018/7/27.
 *
 */
@ContextConfiguration(classes= AliyunOssApplication.class)
public class TestNG extends AbstractTestNGSpringContextTests {

    @Autowired private ApplicationContext ac;

    @Autowired AliyunOssConfig aliyunOssConfig;


    // 查看 spring 容器中 加载的所有bean
    @Test
    public void test0() {
        String[] str= ac.getBeanDefinitionNames();
        for (String string : str) {
            System.out.println("***---***"+string);
        }
    }

    // 查看 spring 容器中  是否 加载 aliyunOssConfig
    @Test
    public void test1() {
        System.out.println(aliyunOssConfig);
    }

    // 方法重构后   上传文件
    @Test
    public void uploadOss() {
        aliyunOssConfig.setLocalPath("D:/123/222.rar");
        aliyunOssConfig.setYunPath("goat/333.rar");
        String tag =OssUtil.uploadOss(aliyunOssConfig);
        System.out.println(tag);
    }

    // 方法重构后   下载文件
    @Test
    public void downloadOss() {
        aliyunOssConfig.setLocalPath("D:/123/");
        aliyunOssConfig.setYunPath("goat/333.rar");
        String tag = OssUtil.downloadOss(aliyunOssConfig);
        System.out.println(tag);
    }

    // 方法重构后   删除文件
    @Test
    public void deleteOss() {
        aliyunOssConfig.setYunPath("goat/333.rar");
        OssUtil.deleteOss(aliyunOssConfig);
    }

    // 方法重构后   判断文件是否存在
    @Test
    public void test11() {
        aliyunOssConfig.setYunPath("goat/333.rar");
        boolean temp = OssUtil.isExistOss(aliyunOssConfig);
        System.out.println(temp);
    }

}
