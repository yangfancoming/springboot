package com.goat.chapter206.config;

import java.io.Serializable;

/**
 * Created by Administrator on 2020/3/10.
 *
 * @ Description: TODO
 * @ author  山羊来了
 * @ date 2020/3/10---13:37
 */
public class HdfsConfig implements Serializable {

    private static final long serialVersionUID = -3927708731917979149L;
    // hdfs 服务器地址
    private String hostname;
    // hdfs 服务器端口
    private String port;
    // hdfs 服务器账户
    private String username;

    // 构造函数
    public HdfsConfig() {
    }

    public HdfsConfig(String hostname, String port, String username) {
        this.hostname = hostname;
        this.port = port;
        this.username = username;
    }

    public String getHostname() {
        return hostname;
    }
    public void setHostname(String hostname) {
        this.hostname = hostname;
    }
    public String getPort() {
        return port;
    }
    public void setPort(String port) {
        this.port = port;
    }
    public String getUsername() {
        return username;
    }
    public void setUsername(String username) {
        this.username = username;
    }

}
