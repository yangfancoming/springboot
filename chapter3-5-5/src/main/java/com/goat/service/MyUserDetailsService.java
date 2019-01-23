package com.goat.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by 64274 on 2018/12/29.
 *
 * @ Description: TODO
 * @ author  山羊来了
 * @ date 2018/12/29---15:58
 */
@Service
public class MyUserDetailsService implements UserDetailsService {

    /**
     * 授权的时候是对角色授权，而认证的时候应该基于资源，而不是角色，因为资源是不变的，而用户的角色是会变的
     */
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        // 模拟数据库查出的用户对象
        Map<String,String> sysUser = new HashMap<>();
        sysUser.put("username","goat");
        sysUser.put("password","123");
        if (null == sysUser) {
            throw new UsernameNotFoundException(username);// 登录失败 跳转到 failureUrl("/login?error")
        }
        /*
        *  这里设置权限和角色
        *  sos 有个大坑。。。 前台对应的 <div sec:authorize="hasRole('VIP2')">  VIP2角色 后台这里需要 加上 ROLE_ 前缀才可以的！！！
        * */
        List<SimpleGrantedAuthority> authorities = new ArrayList<>();
        authorities.add( new SimpleGrantedAuthority("ROLE_VIP1") );
        authorities.add( new SimpleGrantedAuthority("ROLE_VIP2") );
        authorities.add( new SimpleGrantedAuthority("ROLE_VIP3") );
        return new User(sysUser.get("username"), sysUser.get("password"), authorities);
    }
}