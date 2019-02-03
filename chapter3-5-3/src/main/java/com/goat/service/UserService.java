package com.goat.service;

import com.goat.config.JwtUtils;
import com.goat.dto.UserDto;
import org.apache.shiro.crypto.hash.Sha256Hash;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;

/**
 * 用户信息接口
 */
@Service
public class UserService {
	
	private static final String encryptSalt = "F12839WhsnnEV$#23b";

    /** 保存user登录信息，返回token */
    public String generateJwtToken(String username) {
        System.out.println("进入 UserService---generateJwtToken() 生成操作。。。。。。。。。。。。。。");
    	String salt = "12345";//JwtUtils.generateSalt();
    	return JwtUtils.sign(username, salt, 3600); //生成jwt token，设置过期时间为1小时
    }
    
    /**
     * 获取上次token生成时的salt值和登录用户信息
     * @param username
     * @return
     */
    public UserDto getJwtTokenInfo(String username) {
        System.out.println("进入 UserService---getJwtTokenInfo() 获取上次生成的token信心。。。。。。。。。。。。。。数据库操作");
    	String salt = "12345";
    	/**
    	 * @todo 从数据库或者缓存中取出jwt token生成时用的salt
    	 * salt = redisTemplate.opsForValue().get("token:"+username);
    	 */   	
    	UserDto user = getUserInfo(username);
    	user.setSalt(salt);
    	return user;
    }

    /**
     * 清除token信息
     * @param userName 登录用户名
     * @param terminal 登录终端
     */
    public void deleteLoginInfo(String username) {
    	/**
    	 * @todo 删除数据库或者缓存中保存的salt
    	 * redisTemplate.delete("token:"+username);
    	 */
    	
    }
    
    /**
     * 获取数据库中保存的用户信息，主要是加密后的密码
     * @param userName
     * @return
     */
    public UserDto getUserInfo(String userName) {
        System.out.println("进入 UserService---getUserInfo() 获取数据库中保存的用户信息。。。。。。。。。。。。。。数据库操作");
    	UserDto user = new UserDto();
    	user.setUserId(1L);
    	user.setUsername("admin");
    	user.setEncryptPwd(new Sha256Hash("123456", encryptSalt).toHex());
    	return user;
    }
    
    /**
     * 获取用户角色列表，强烈建议从缓存中获取
     * @param userId
     * @return
     */
    public List<String> getUserRoles(Long userId){
        System.out.println("进入 UserService---getUserRoles() 获取用户角色列表。。。。。。。。。。。。。。数据库操作");
    	return Arrays.asList("admin");
    }

}
