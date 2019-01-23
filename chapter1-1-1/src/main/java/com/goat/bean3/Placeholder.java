package com.goat.bean3;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

import java.io.Serializable;

/**
 * Created by 64274 on 2018/7/14.
 *
 * @author 山羊来了
 * @Description:   属性校检注入
 * @date 2018/7/14---21:01
 *
 * @Validated 和 @Email 一起使用 来校检 某些字段格式  要打开注释就一起打开
 * 配置文件中的占位符 相关知识
 */
@PropertySource( value= {"classpath:placeholder.properties"})
@Configuration
@ConfigurationProperties(prefix = "app")
//@Validated
public class Placeholder implements Serializable {

//    @Email // name属性的值 必须是  Email 格式 否则报错
    String name;
    String description;
    String title;
    Integer age;

    @Override
    public String toString() {
        return "Placeholder{" + "name='" + name + '\'' + ", description='" + description + '\'' + ", title='" + title + '\'' + ", age=" + age + '}';
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
