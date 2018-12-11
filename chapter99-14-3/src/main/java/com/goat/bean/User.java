package com.goat.bean;

import com.goat.annotation.Column;
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


    private Boolean userSex;
}
