package com.goat.bean3;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

/**
 * Created by 64274 on 2018/7/14.
 *
 * @author 山羊来了
 * @Description: TODO
 * @date 2018/7/14---21:01
 *
 * 配置文件中的占位符 相关知识
 */
@PropertySource( value= {"classpath:placeholder.properties"})
@Configuration
@ConfigurationProperties(prefix = "app")
public class Placeholder {
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
