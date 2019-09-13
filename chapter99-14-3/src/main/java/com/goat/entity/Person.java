package com.goat.entity;

import com.goat.annotation.Column;
import com.goat.annotation.Init;
import com.goat.annotation.Table;
import com.goat.annotation.Validate;

/**
 * Created by 64274 on 2018/12/11.
 *
 * @ Description: TODO
 * @ author  山羊来了
 * @ date 2018/12/11---21:25
 */

@Table(tb_name = "my_user")
public class Person {

    @Column
    private Boolean userSex;

    @Column(col_name = "user_age")
    private Integer userAge;

    @Init("13845632145")
    private String phone;

    @Validate(min = 2, max = 5)
    private String userName;


    @Validate(isNotNull = false)
    private String sex;

    public Boolean getUserSex() {
        return userSex;
    }

    public void setUserSex(Boolean userSex) {
        this.userSex = userSex;
    }

    public Integer getUserAge() {
        return userAge;
    }

    public void setUserAge(Integer userAge) {
        this.userAge = userAge;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }
}
