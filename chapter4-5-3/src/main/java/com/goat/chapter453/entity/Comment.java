package com.goat.chapter453.entity;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.CompoundIndex;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.Date;

/**
 * Created by Administrator on 2020/2/24.
 * @ Description: TODO
 * @ author  山羊来了
 * @ date 2020/2/24---14:31
 */

// 将该文档关联到指定集合    若省略，则默认关联到 Comment类首字母小写的集合中去
@Document(collection = "comment")
//@CompoundIndex(def = "{'userid':1,'nickname':-1}") // userid 字段升序，nickname字段降序的符合索引
public class Comment implements Serializable {


    // 主键标识，该属性的值会自动对应mongodb的主键字段 _id
    // 如果该属性名就叫 id，那么该注解可以省略不写，否则必须写
    @Id
    private String id;

    private String articleId;// 文章id


    @Field("content") // 该属性对应mongodb字段的名称，如果一致，可以省略
    private String content; // 吐槽内容

    private Date publishtime; // 发布日期

    @Indexed // 添加一个单字段的索引
    private String userid; // 发布人id

    private String nickname; //  评论人昵称

    private LocalDateTime createdatetime; //  评论的日期时间

    private Integer likenum; //  点赞数

    private Integer replynum; //  回复数

    private String state; //  状态  0 不可见 1可见

    private String parentid; //   上级id   0为顶级评论

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getArticleId() {
        return articleId;
    }

    public void setArticleId(String articleId) {
        this.articleId = articleId;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Date getPublishtime() {
        return publishtime;
    }

    public void setPublishtime(Date publishtime) {
        this.publishtime = publishtime;
    }

    public String getUserid() {
        return userid;
    }

    public void setUserid(String userid) {
        this.userid = userid;
    }

    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    public LocalDateTime getCreatedatetime() {
        return createdatetime;
    }

    public void setCreatedatetime(LocalDateTime createdatetime) {
        this.createdatetime = createdatetime;
    }

    public Integer getLikenum() {
        return likenum;
    }

    public void setLikenum(Integer likenum) {
        this.likenum = likenum;
    }

    public Integer getReplynum() {
        return replynum;
    }

    public void setReplynum(Integer replynum) {
        this.replynum = replynum;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getParentid() {
        return parentid;
    }

    public void setParentid(String parentid) {
        this.parentid = parentid;
    }
}
