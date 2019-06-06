package com.goat.doit.config;

import com.goat.doit.model.User;
import com.goat.doit.service.UserService;
import com.goat.doit.util.CoreConst;
import org.apache.shiro.authc.*;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.apache.shiro.util.ByteSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
     * @Description:  自定义 Realm 类  需要继承shiro 提供的  AuthorizingRealm类
     * @author: 杨帆
     * @Date:   2018/11/7
*/
@Component
public class MyShiroRealm extends AuthorizingRealm {


    @Autowired
    private UserService userService;

    /**
      sos 错误积累： Wildcard string cannot be null or empty. Make sure permission strings are properly formatte
     是由于  authInfo.addStringPermission(null)
    */

    /* 执行授权 ：*/
    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principals) {
        System.out.println("执行授权方法");
        // 给资源进行授权
        SimpleAuthorizationInfo authInfo = new SimpleAuthorizationInfo();
        User userInfo  = (User) principals.getPrimaryPrincipal();
        System.out.println(userInfo);
        authInfo.addStringPermission("hello:add");// 授予 对应  filterChainDefinitionMap.put("/hello/add", "perms[hello:add]");  访问权限
        authInfo.addStringPermission("hello:update");// 授予 对应  filterChainDefinitionMap.put("/hello/add", "perms[hello:edit]");  访问权限
        return authInfo;
    }

    /* 执行认证 ： 主要是用来进行身份认证的，也就是说验证用户输入的账号和密码是否正确。*/
    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken token) throws AuthenticationException {
        System.out.println("执行认证方法");
        String username = (String)token.getPrincipal();  //获取用户的输入的账号
        User user = userService.selectByUsername(username);
        if(user==null) {
            throw new UnknownAccountException();
        }
        if (CoreConst.STATUS_INVALID.equals(user.getStatus())) {
            // 帐号锁定
            throw new LockedAccountException();
        }
        /**
         *  P1 = 数据库账号  P2 = 数据库密码  P3 =  定死的
         *  这些需要注意的是   如果 SecurityManager 管理器函数中  securityManager.setRealm(myShiroRealm)
         *  设置的自定义realm  又设置了 hashedCredentialsMatcher 的 MD5 那么 P2 必须是 经过 M5 加密的
         *
         * */
        // 2. 判断密码
//        SimpleAuthenticationInfo authenticationInfo = new SimpleAuthenticationInfo(user,user.getPassword(), ByteSource.Util.bytes(user.getCredentialsSalt()),getName());
        SimpleAuthenticationInfo authenticationInfo = new SimpleAuthenticationInfo(user,user.getPassword(),getName());
        return authenticationInfo;
    }

}