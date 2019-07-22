package com.goat.springboot.solr.model;

import org.apache.solr.client.solrj.beans.Field;

import java.io.Serializable;

/**
 * Created by 64274 on 2019/7/22.
 *
 * @ Description: TODO
 * @ author  山羊来了
 * @ date 2019/7/22---10:22
 */
public class User implements Serializable {
    //必须实现可序列化接口，要在网络上传输 使用这个注释，里面的名字是根据你在solr数据库中配置的来决定
    @Field("id")
    private String id;
    @Field("item_name")
    private String name;
    @Field("item_sex")
    private String sex;
    @Field("item_address")
    private String address;
    @Field("item_host")
    private Integer host;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public Integer getHost() {
        return host;
    }

    public void setHost(Integer host) {
        this.host = host;
    }
}
