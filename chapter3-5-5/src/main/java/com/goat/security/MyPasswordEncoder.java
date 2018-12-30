package com.goat.security;

import org.springframework.security.crypto.password.PasswordEncoder;

/**
 * Created by 64274 on 2018/7/27.
 *
 * @author 山羊来了
 * @Description: 自定义密码验证
 * @date 2018/7/27---20:06
 */
public class MyPasswordEncoder implements PasswordEncoder {

    // 加密方法  对原始密码进行加密
    @Override
    public String encode(CharSequence charSequence) {
        return charSequence.toString();
    }

    // 匹配方法   原始密码 与 加密后密码 进行匹配
    @Override
    public boolean matches(CharSequence charSequence, String s) {
        return s.equals(charSequence.toString());
    }


}
