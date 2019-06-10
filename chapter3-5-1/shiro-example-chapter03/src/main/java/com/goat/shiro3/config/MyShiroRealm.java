package com.goat.shiro3.config;

import com.goat.shiro3.bean.User;
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
     * @Date:   2018/11/7
*/
@Component
public class MyShiroRealm extends AuthorizingRealm {

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
//        User user = userService.selectByUsername(username);
        User user = new User(1,"admin","12345");
        // 1. 判断账号
        if(!username.equals(user.getUsername())){
            return null;// 如果 输入的账号和数据库中账号不相同 那么这里 null 会使 shiro 抛出 UnknownAccountException 异常
        }
        /**
         *  P1 = 数据库账号  P2 = 数据库密码  P3 =  定死的
         *  这些需要注意的是   如果 SecurityManager 管理器函数中  securityManager.setRealm(myShiroRealm)
         *  设置的自定义realm  又设置了 hashedCredentialsMatcher 的 MD5 那么 P2 必须是 经过 M5 加密的
         *  如果加密了不知道加密的密码   就去掉 盐值 再将表中的密码改成明文的
         * */
        // 2. 判断密码
        SimpleAuthenticationInfo authenticationInfo = new SimpleAuthenticationInfo(user,user.getPassword(),getName());
        return authenticationInfo;
    }



    /**
     * 重写方法,清除当前用户的的 授权缓存
     * @param principals
     */
    @Override
    public void clearCachedAuthorizationInfo(PrincipalCollection principals) {
        super.clearCachedAuthorizationInfo(principals);
    }

    /**
     * 重写方法，清除当前用户的 认证缓存
     * @param principals
     */
    @Override
    public void clearCachedAuthenticationInfo(PrincipalCollection principals) {
        super.clearCachedAuthenticationInfo(principals);
    }

    @Override
    public void clearCache(PrincipalCollection principals) {
        super.clearCache(principals);
    }

    /**
     * 自定义方法：清除所有 授权缓存
     */
    public void clearAllCachedAuthorizationInfo() {
        getAuthorizationCache().clear();
    }

    /**
     * 自定义方法：清除所有 认证缓存
     */
    public void clearAllCachedAuthenticationInfo() {
        getAuthenticationCache().clear();
    }

    /**
     * 自定义方法：清除所有的  认证缓存  和 授权缓存
     */
    public void clearAllCache() {
        clearAllCachedAuthenticationInfo();
        clearAllCachedAuthorizationInfo();
    }
}