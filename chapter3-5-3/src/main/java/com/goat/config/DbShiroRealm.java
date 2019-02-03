package com.goat.config;


import com.goat.dto.UserDto;
import com.goat.service.UserService;
import org.apache.shiro.authc.*;
import org.apache.shiro.authc.credential.HashedCredentialsMatcher;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.crypto.hash.Sha256Hash;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.apache.shiro.util.ByteSource;

import java.util.List;

public class DbShiroRealm extends AuthorizingRealm {

	private static final String encryptSalt = "F12839WhsnnEV$#23b";//数据库存储的用户密码的加密salt，正式环境不能放在源代码里

	private UserService userService;
	
	public DbShiroRealm(UserService userService) {
		this.userService = userService;
		this.setCredentialsMatcher(new HashedCredentialsMatcher(Sha256Hash.ALGORITHM_NAME));//因为数据库中的密码做了散列，所以使用shiro的散列Matcher
	}

    /**
     *  找它的原因是这个方法返回true，大坑！，必须重写此方法，不然Shiro会报错
     */
    @Override
    public boolean supports(AuthenticationToken token) {
        return token instanceof UsernamePasswordToken;
    }

    /**
     *  这一步我们根据token给的用户名，去数据库查出加密过用户密码，然后把加密后的密码和盐值一起发给shiro，让它做比对
     *  执行认证 ： 主要是用来进行身份认证的，也就是说验证用户输入的账号和密码是否正确。
     */
	@Override
	protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken token) throws AuthenticationException {
		UsernamePasswordToken userpasswordToken = (UsernamePasswordToken)token;
		String username = userpasswordToken.getUsername();  // 解密获得 username，用于和数据库进行对比
		UserDto user = userService.getUserInfo(username);
		if(user == null) throw new AuthenticationException("用户名或者密码错误");
		return new SimpleAuthenticationInfo(user, user.getEncryptPwd(), ByteSource.Util.bytes(encryptSalt), "dbRealm");
	}

    /**
     * 只有当需要检测用户权限的时候才会调用此方法，例如checkRole,checkPermission之类的
     * 执行授权 ： 主要是用来进行身份认证的，也就是说验证用户输入的账号和密码是否正确。
     */
	@Override
	protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principals) {      
        SimpleAuthorizationInfo simpleAuthorizationInfo = new SimpleAuthorizationInfo();
        UserDto user = (UserDto) principals.getPrimaryPrincipal();
        List<String> roles = user.getRoles();
        if(roles == null) {
            roles = userService.getUserRoles(user.getUserId());
            user.setRoles(roles);
        }
        if (roles != null) simpleAuthorizationInfo.addRoles(roles);
        return simpleAuthorizationInfo;
	}

}
