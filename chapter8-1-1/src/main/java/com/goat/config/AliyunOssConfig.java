package com.goat.config;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

/**
 * 阿里云OSS配置信息
 */
@Configuration
@PropertySource(value = "classpath:aliyun-oss.properties")
@ConfigurationProperties(prefix = "oss-aliyun")
public class AliyunOssConfig {
    private String accessKey;
    private String secretKey;
    private String bucket;
    private String endPoint;

    // 以下两个是额外参数 用于传递 两个路径参数
    private String localPath; // 本地待上传文件路径 "D:/123/222.rar"
    private String yunPath;  //  阿里云服务器 存储路径 "goat/333.rar

    public String getAccessKey() {
        return accessKey;
    }

    public void setAccessKey(String accessKey) {
        this.accessKey = accessKey;
    }

    public String getSecretKey() {
        return secretKey;
    }

    public void setSecretKey(String secretKey) {
        this.secretKey = secretKey;
    }

    public String getBucket() {
        return bucket;
    }

    public void setBucket(String bucket) {
        this.bucket = bucket;
    }

    public String getEndPoint() {
        return endPoint;
    }

    public void setEndPoint(String endPoint) {
        this.endPoint = endPoint;
    }

    public String getLocalPath() {
        return localPath;
    }

    public void setLocalPath(String localPath) {
        this.localPath = localPath;
    }

    public String getYunPath() {
        return yunPath;
    }

    public void setYunPath(String yunPath) {
        this.yunPath = yunPath;
    }
}
