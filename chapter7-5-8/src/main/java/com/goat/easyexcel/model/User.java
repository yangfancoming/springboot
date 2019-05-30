package com.goat.easyexcel.model;

import com.alibaba.excel.annotation.ExcelProperty;
import com.alibaba.excel.metadata.BaseRowModel;


public class User extends BaseRowModel {

    @ExcelProperty(value = "姓名" , index = 0)
    private String name;
    @ExcelProperty(value = "年龄" , index = 1)
    private int age;
    @ExcelProperty(value = "性别" , index = 2)
    private String sex;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }
}
