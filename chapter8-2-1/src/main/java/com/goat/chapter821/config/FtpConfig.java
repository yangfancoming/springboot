package com.goat.chapter821.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

/**
 * ftp服务器相关配置信息
 */
@Component
public class FtpConfig {
	/**
	 * ftp服务器地址
	 */
	@Value("${ftp.url}")
	private String url;
	
	/**
	 * ftp服务器端口
	 */
	@Value("${ftp.port}")
	private int port;
	
	/**
	 * ftp服务器用户名
	 */
	@Value("${ftp.username}")
	private String username;
	
	/**
	 * ftp服务器密码
	 */
	@Value("${ftp.password}")
	private String password;
	
	/**
	 * ftp服务器存放文件的路径
	 */
	@Value("${ftp.remotePath}")
	private String remotePath;
	
	/**
	 * 本地需要上传的文件的路径
	 */
	@Value("${ftp.localDir}")
	private String localDir;
	
	/**
	 * 下载文件时，存放在本地的路径
	 */
	@Value("${ftp.downDir}")
	private String downDir;

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public int getPort() {
        return port;
    }

    public void setPort(int port) {
        this.port = port;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getRemotePath() {
        return remotePath;
    }

    public void setRemotePath(String remotePath) {
        this.remotePath = remotePath;
    }

    public String getLocalDir() {
        return localDir;
    }

    public void setLocalDir(String localDir) {
        this.localDir = localDir;
    }

    public String getDownDir() {
        return downDir;
    }

    public void setDownDir(String downDir) {
        this.downDir = downDir;
    }
}
