package com.goat.doit.shiro;

import com.goat.doit.model.User;
import com.goat.doit.service.PermissionService;
import com.goat.doit.service.RoleService;
import com.goat.doit.service.UserService;
import com.goat.doit.util.CoreConst;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.*;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.mgt.RealmSecurityManager;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.session.Session;
import org.apache.shiro.subject.PrincipalCollection;
import org.apache.shiro.subject.SimplePrincipalCollection;
import org.apache.shiro.subject.support.DefaultSubjectContext;
import org.crazycake.shiro.RedisSessionDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Set;

/**
 自定义 Realm 类  需要继承shiro 提供的  AuthorizingRealm类
*/
@Component
public class MyShiroRealm extends AuthorizingRealm {


    @Autowired
    private UserService userService;
    @Autowired
    private RoleService roleService;

    @Autowired
    private PermissionService permissionService;

    @Autowired
    private RedisSessionDAO redisSessionDAO;

    /**
      sos 错误积累： Wildcard string cannot be null or empty. Make sure permission strings are properly formatte
     是由于  authInfo.addStringPermission(null)
    */

    /* 执行授权 ：*/
    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principals) {
        System.out.println("执行授权方法");
        // 给资源进行授权
        User user  = (User) principals.getPrimaryPrincipal();
        SimpleAuthorizationInfo authInfo = new SimpleAuthorizationInfo();
        authInfo.setRoles(roleService.findRoleByUserId(user.getId()));
        /** doit
         * 为啥 findPermsByUserId() 一条龙 换成 Interger 就报错呢？
         * 报错： thymeleaf  java.sql.SQLException: Invalid value for getInt() - 'workdest'
        */
        Set<String> permsByUserId = permissionService.findPermsByUserId(user.getId().toString());
        authInfo.setStringPermissions(permsByUserId);
        return authInfo;

    }

    /* 执行认证 ： 主要是用来进行身份认证的，也就是说验证用户输入的账号和密码是否正确。*/
    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken token) throws AuthenticationException {
        System.out.println("执行认证方法");
        String username = (String)token.getPrincipal();  //获取用户的输入的账号
        User user = userService.selectByUsername(username);
        if(user==null) { // 用户不存在
            throw new UnknownAccountException();
        }
        if (CoreConst.STATUS_INVALID.equals(user.getStatus())) {  // 帐号锁定
            throw new LockedAccountException();
        }
        /**
         *  P1 = 数据库账号  P2 = 数据库密码  P3 =  定死的
         *  这些需要注意的是   如果 SecurityManager 管理器函数中  securityManager.setRealm(myShiroRealm)
         *  设置的自定义realm  又设置了 hashedCredentialsMatcher 的 MD5 那么 P2 必须是 经过 M5 加密的
         *
         * */
        // 2. 判断密码
//        ByteSource bytes = ByteSource.Util.bytes(user.getCredentialsSalt());
//        PasswordHelper.encryptPassword(user);
//        SimpleAuthenticationInfo authenticationInfo = new SimpleAuthenticationInfo(user,user.getPassword(),bytes ,getName());
        SimpleAuthenticationInfo authenticationInfo = new SimpleAuthenticationInfo(user,user.getPassword(),getName());
        return authenticationInfo;
    }


    /**
     * 根据userId 清除当前session存在的用户的权限缓存
     * @param userIds 已经修改了权限的userId
     */
    public void clearAuthorizationByUserId(List<String> userIds){
        if(null == userIds || userIds.size() == 0)	{
            return ;
        }
        List<SimplePrincipalCollection> list = getSpcListByUserIds(userIds);
        RealmSecurityManager securityManager =  (RealmSecurityManager) SecurityUtils.getSecurityManager();
        MyShiroRealm realm = (MyShiroRealm)securityManager.getRealms().iterator().next();
        for (SimplePrincipalCollection simplePrincipalCollection : list) {
            realm.clearCachedAuthorizationInfo(simplePrincipalCollection);
        }
    }


    /**
     * 根据用户id获取所有spc
     * @param userIds 已经修改了权限的userId
     */
    private  List<SimplePrincipalCollection> getSpcListByUserIds(List<String> userIds){
        Collection<Session> sessions = redisSessionDAO.getActiveSessions(); //获取所有session
        List<SimplePrincipalCollection> list = new ArrayList<>();   //定义返回
        for (Session session:sessions){
            //获取session登录信息。
            Object obj = session.getAttribute(DefaultSubjectContext.PRINCIPALS_SESSION_KEY);
            if(null != obj && obj instanceof SimplePrincipalCollection){
                //强转
                SimplePrincipalCollection spc = (SimplePrincipalCollection)obj;
                //判断用户，匹配用户ID。
                obj = spc.getPrimaryPrincipal();
                if(null != obj && obj instanceof User){
                    User user = (User) obj;
                    System.out.println("user:"+user);
                    //比较用户ID，符合即加入集合
                    if(null != user && userIds.contains(user.getId())){
                        list.add(spc);
                    }
                }
            }
        }
        return list;
    }

}