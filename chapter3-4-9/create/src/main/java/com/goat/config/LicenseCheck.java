package com.goat.config;

import org.springframework.boot.context.properties.ConfigurationProperties;

import java.util.Arrays;
import java.util.List;

/**
 * license中受检查的相关属性
 */
@ConfigurationProperties(prefix = LicenseCommon.LICENSE_CHECK_PREFIX)
public class LicenseCheck {
    /**
     * license颁发时间
     */
    private String issuedTime;
    /**
     * license生效时间
     */
    private String notBefore;
    /**
     * license失效时间,必须要大于今天的日期,必填
     */
    private String notAfter;
    /**
     * 授权客户类型,默认值user
     */
    private String consumerType = "user";
    /**
     * 授权客户数量
     */
    private int consumerAmount = 1;
    /**
     * license信息
     */
    private String info;

    /**
     * 名字与姓氏,默认值Unknown
     */
    private String commonName = "Unknown";

    /**
     * 国家名称,默认值Unknown
     */
    private String country = "Unknown";

    /**
     * 城市或区域名称,默认值Unknown
     */
    private String locality = "Unknown";

    /**
     * 州或省份名称,默认值Unknown
     */
    private String state = "Unknown";

    /**
     * 其他受检查的相关属性，mac ip
     */
//    private LicenseExtra extra;
    private List<String> macAddress;

    public String getIssuedTime() {
        return issuedTime;
    }

    public void setIssuedTime(String issuedTime) {
        this.issuedTime = issuedTime;
    }

    public String getNotBefore() {
        return notBefore;
    }

    public void setNotBefore(String notBefore) {
        this.notBefore = notBefore;
    }

    public String getNotAfter() {
        return notAfter;
    }

    public void setNotAfter(String notAfter) {
        this.notAfter = notAfter;
    }

    public String getConsumerType() {
        return consumerType;
    }

    public void setConsumerType(String consumerType) {
        this.consumerType = consumerType;
    }

    public int getConsumerAmount() {
        return consumerAmount;
    }

    public void setConsumerAmount(int consumerAmount) {
        this.consumerAmount = consumerAmount;
    }

    public String getInfo() {
        return info;
    }

    public void setInfo(String info) {
        this.info = info;
    }

    public String getCommonName() {
        return commonName;
    }

    public void setCommonName(String commonName) {
        this.commonName = commonName;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getLocality() {
        return locality;
    }

    public void setLocality(String locality) {
        this.locality = locality;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public List<String> getMacAddress() {
        return macAddress;
    }

    public void setMacAddress(List<String> macAddress) {
        this.macAddress = macAddress;
    }

    @Override
    public String toString() {
        String str = "LicenseCheck{" +
                "issuedTime='" + issuedTime + '\'' +
                ", notBefore='" + notBefore + '\'' +
                ", notAfter='" + notAfter + '\'' +
                ", consumerType='" + consumerType + '\'' +
                ", consumerAmount=" + consumerAmount +
                ", info='" + info + '\'' +
                ", commonName='" + commonName + '\'' +
                ", country='" + country + '\'' +
                ", locality='" + locality + '\'' +
                ", state='" + state + '\'';
        if (macAddress != null) {
            str += ", macAddress=" + Arrays.toString(macAddress.toArray());
        }
        str += '}';
        return str;
    }
}
