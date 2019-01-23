package com.goat.entity;

import com.goat.annotation.Column;
import com.goat.annotation.Init;
import com.goat.annotation.Table;

/**
 * Created by 64274 on 2018/12/11.
 *
 * @ Description: TODO
 * @ author  山羊来了
 * @ date 2018/12/11---21:25
 */

@Table(tb_name = "my_user")
public class User {

    @Column(col_name = "user_name")
    private String userName;

    @Column
    private Boolean userSex;

    @Column(col_name = "user_age")
    private Integer userAge;

    @Init(value = "13845632145")
    private String phone;

}
