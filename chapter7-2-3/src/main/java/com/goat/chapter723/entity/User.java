package com.goat.chapter723.entity;


import org.apache.solr.client.solrj.beans.Field;
import org.springframework.data.solr.core.mapping.SolrDocument;

import java.io.Serializable;
import java.util.Date;

/**
 * user entity
 *
 * @author nickbi
 * @date 2019/1/21
 */

@SolrDocument(solrCoreName = "user", collection = "user")
public class User implements Serializable {

    private static final long serialVersionUID = 6437870368800677897L;

    @Field("id")
    private String id;

    @Field("username")
    private String username;

    @Field("password")
    private String password;

    @Field("remark")
    private String remark;

    @Field("createDate")
    private Date createDate;



    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
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

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    public Date getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }
}
