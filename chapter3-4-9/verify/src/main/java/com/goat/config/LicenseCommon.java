package com.goat.config;

import org.springframework.boot.context.properties.ConfigurationProperties;

/**
 * license公共参数
 */
@ConfigurationProperties(prefix = LicenseCommon.LICENSE_CHECK_PREFIX)
public class LicenseCommon {
    public final static String LICENSE_CHECK_PREFIX = "license.verify";

    /**
     * 密钥库的存储路径,必填
     */
    private String resource;
    /**
     * 密钥库的别名,必填
     */
    private String alias;
    /**
     * 密钥库的存储密码,必填
     */
    private String storepass;
    /**
     * 密钥库的密码
     */
//    private String keypass;
    /**
     * 主题,必填
     */
    private String subject;
    /**
     * license文件保存路径,必填
     */
    private String licensePath;


    public String getResource() {
        return resource;
    }

    public void setResource(String resource) {
        this.resource = resource;
    }

    public String getAlias() {
        return alias;
    }

    public void setAlias(String alias) {
        this.alias = alias;
    }

    public String getStorepass() {
        return storepass;
    }

    public void setStorepass(String storepass) {
        this.storepass = storepass;
    }

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    public String getLicensePath() {
        return licensePath;
    }

    public void setLicensePath(String licensePath) {
        this.licensePath = licensePath;
    }

    @Override
    public String toString() {
        return "LicenseCommon{" +
                "resource='" + resource + '\'' +
                ", alias='" + alias + '\'' +
                ", storePass='" + storepass + '\'' +
                ", subject='" + subject + '\'' +
                ", licensePath='" + licensePath + '\'' +
                '}';
    }
}
