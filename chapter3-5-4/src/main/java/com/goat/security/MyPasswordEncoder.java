package com.goat.security;

import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

/**
 * Created by 64274 on 2018/7/27.
 *
 * @author 山羊来了
 * @Description: TODO
 * @date 2018/7/27---20:06
 */
@Component
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
