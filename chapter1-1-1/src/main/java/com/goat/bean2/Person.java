package com.goat.bean2;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

import java.util.Date;
import java.util.List;
import java.util.Map;

/**
 * Created by 64274 on 2018/7/14.
 *
 * @author 山羊来了
 * @Description: TODO
 * @date 2018/7/14---19:19
    Spring @Configuration 和 @Component 区别
    一句话概括就是 @Configuration 中所有带 @Bean 注解的方法都会被动态代理，
    因此调用该方法返回的都是同一个实例。
    而 @Component 则是 可能产生多个 因为每次都去new

     * 将配置文件中配置的每一个属性的值，映射到这个组件中
     *  @ ConfigurationProperties：告诉SpringBoot将本类中的所有属性和配置文件中相关的配置进行绑定；
 *      @ ConfigurationProperties：默认从两个全局配置文件 获取属性值
     *      prefix = "person"：配置文件中哪个下面的所有属性进行一一映射
     *
     * sos 只有这个组件是容器中的组件，才能提供容器的 @ConfigurationProperties 功能；
 *
 *
 *  @Configuration 标记的类必须符合下面的要求：
    配置类必须以类的形式提供（不能是工厂方法返回的实例），允许通过生成子类在运行时增强（cglib 动态代理）。
    配置类不能是 final 类（没法动态代理）。
    配置注解通常为了通过 @Bean 注解生成 Spring 容器管理的类，
    配置类必须是非本地的（即不能在方法中声明，不能是 private）。
    任何嵌套配置类都必须声明为static。
     @Bean 方法可能不会反过来创建进一步的配置类（也就是返回的 bean 如果带有 @Configuration，也不会被特殊处理，只会作为普通的 bean）。


  * 将配置文件中配置的每一个属性的值，映射到这个组件中
  * @ConfigurationProperties：告诉SpringBoot将本类中的所有属性和配置文件中相关的配置进行绑定；
 *      prefix = "person"：配置文件中哪个下面的所有属性进行一一映射
 *
 * 只有这个组件是容器中的组件，才能容器提供的@ConfigurationProperties功能；
 *  @ConfigurationProperties(prefix = "person")默认从全局配置文件中获取值；
 */
@Configuration
@ConfigurationProperties(prefix = "person")
public class Person {

    private String lastName;
    private Integer age;
    private Boolean boss;
    private Date birth;
    private Map<String, Object> maps;
    private List<Object> lists;
    private Pet pet;

    @Override
    public String toString() {
        return "Person{" + "lastName='" + lastName + '\'' + ", age=" + age + ", boss=" + boss + ", birth=" + birth + ", maps=" + maps + ", lists=" + lists + ", pet=" + pet + '}';
    }

    public Pet getPet() {
        return pet;
    }

    public void setPet(Pet pet) {
        this.pet = pet;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public Boolean getBoss() {
        return boss;
    }

    public void setBoss(Boolean boss) {
        this.boss = boss;
    }

    public Date getBirth() {
        return birth;
    }

    public void setBirth(Date birth) {
        this.birth = birth;
    }

    public Map<String, Object> getMaps() {
        return maps;
    }

    public void setMaps(Map<String, Object> maps) {
        this.maps = maps;
    }

    public List<Object> getLists() {
        return lists;
    }

    public void setLists(List<Object> lists) {
        this.lists = lists;
    }




}