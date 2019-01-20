package com.goat.config;

//import com.neo.entity.SysPermission;
//import com.neo.entity.SysRole;
//import com.neo.entity.UserInfo;
//import com.neo.sevice.UserInfoService;

import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.SimpleAuthenticationInfo;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.springframework.stereotype.Component;

/**
     * @Description:  自定义 Realm 类  需要继承shiro 提供的  AuthorizingRealm类
     * @author: 杨帆
     * @Param:
     * @Return:
     * @Date:   2018/11/7
*/
@Component
public class MyShiroRealm extends AuthorizingRealm {

    /* 执行授权 ： 主要是用来进行身份认证的，也就是说验证用户输入的账号和密码是否正确。*/
    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principals) {
        System.out.println("执行授权方法");
        // 给资源进行授权
        SimpleAuthorizationInfo authorizationInfo = new SimpleAuthorizationInfo();
        authorizationInfo.addStringPermission("hello:add");// 授予 对应  filterChainDefinitionMap.put("/hello/add", "perms[hello:add]");  访问权限
//        UserInfo userInfo  = (UserInf)principals.getPrimaryPrincipal();
//        for(SysRole role:userInfo.getRoleList()){
//            authorizationInfo.addRole(role.getRole());
//            for(SysPermission p:role.getPermissions()){
//                authorizationInfo.addStringPermission(p.getPermission());
//            }
//        }
        return authorizationInfo;
    }

    /* 执行认证 ： 主要是用来进行身份认证的，也就是说验证用户输入的账号和密码是否正确。*/
    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken token) throws AuthenticationException {
        System.out.println("执行认证方法");
        String judgeName = "goat";
        String username = (String)token.getPrincipal();  //获取用户的输入的账号

        // 1. 判断账号
        if(!username.equals(judgeName)){
            return null;// 如果 输入的账号和数据库中账号不相同 那么这里 null 会使 shiro 抛出 UnknownAccountException 异常
        }
        /**
         *  P1 = 数据库账号  P2 = 数据库密码  P3 =  定死的
         *  这些需要注意的是   如果 SecurityManager 管理器函数中  securityManager.setRealm(myShiroRealm)
         *  设置的自定义realm  又设置了 hashedCredentialsMatcher 的 MD5 那么 P2 必须是 经过 M5 加密的
         * */
        // 2. 判断密码
        SimpleAuthenticationInfo authenticationInfo = new SimpleAuthenticationInfo(judgeName,"1234",getName());
        return authenticationInfo;
    }

}