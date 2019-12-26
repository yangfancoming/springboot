package com.goat.chapter239.model;

import java.util.Date;

/**
 * Created by Administrator on 2019/11/22.
 *
 * @ Description: TODO
 * @ author  山羊来了
 * @ date 2019/11/22---11:57
 */
public class Dtu {

    // dtu ip
    public String ip;
    // dtu 端口
    public Short port;
    // dtu 身份标识
    public String identity;
    // dtu 注册时间
    public Date time;

    public String getIp() {
        return ip;
    }

    public void setIp(String ip) {
        this.ip = ip;
    }

    public Short getPort() {
        return port;
    }

    public void setPort(Short port) {
        this.port = port;
    }

    public String getIdentity() {
        return identity;
    }

    public void setIdentity(String identity) {
        this.identity = identity;
    }

    public Date getTime() {
        return time;
    }

    public void setTime(Date time) {
        this.time = time;
    }
}
