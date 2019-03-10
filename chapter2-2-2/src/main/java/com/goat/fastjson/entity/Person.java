package com.goat.fastjson.entity;

import com.alibaba.fastjson.annotation.JSONField;

import java.util.Date;

/**
     通过 @JSONField 定制序列化
     ordinal	指定字段的顺序
     name	字段key值
     format	配置日期格式化
     serialize	指定字段是否序列化
     deserialize	指定字段不序列化
     serialzeFeatures	指定规则
*/
public class Person {
     
    @JSONField(name = "AGE")
    private int age;
 
    @JSONField(name = "FULL NAME" ,ordinal = 2)
    private String fullName;
 
    @JSONField(name = "DATE OF BIRTH",format="dd/MM/yyyy",ordinal = 1)
    private Date dateOfBirth;

    @JSONField(serialize=false) // 从 java bean 转成 json 叫 序列化
    private String temp1;

    @JSONField(deserialize=false)  // 从 json  转成 java bean 叫 反序列化
    private String temp2;

    private String temp3;

    private String temp4;



    public Person(int age, String fullName, Date dateOfBirth) {
        super();
        this.age = age;
        this.fullName= fullName;
        this.dateOfBirth = dateOfBirth;
    }

    public Person(int age, String fullName, Date dateOfBirth, String temp1, String temp2, String temp3, String temp4) {
        this.age = age;
        this.fullName = fullName;
        this.dateOfBirth = dateOfBirth;
        this.temp1 = temp1;
        this.temp2 = temp2;
        this.temp3 = temp3;
        this.temp4 = temp4;
    }

    public String getTemp1() {
        return temp1;
    }

    public void setTemp1(String temp1) {
        this.temp1 = temp1;
    }

    public String getTemp2() {
        return temp2;
    }

    public void setTemp2(String temp2) {
        this.temp2 = temp2;
    }

    public String getTemp3() {
        return temp3;
    }

    public void setTemp3(String temp3) {
        this.temp3 = temp3;
    }

    public String getTemp4() {
        return temp4;
    }

    public void setTemp4(String temp4) {
        this.temp4 = temp4;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public Date getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(Date dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }
}