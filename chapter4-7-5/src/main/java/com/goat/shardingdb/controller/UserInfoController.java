package com.goat.shardingdb.controller;


import com.goat.shardingdb.model.UserInfo;
import com.goat.shardingdb.repository.UserInfoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;

/**
 * 用户信息控制器
* @date 2018年5月19日
 */
@RestController
public class UserInfoController {
	@Autowired
    UserInfoRepository userInfoRepository;
	
	/**
	 * 获取所有用户信息  http://localhost:8475/userinfo
	 * @return
	 */
	@GetMapping("/userinfo")
	public List<UserInfo> getUserInfos(){
		return userInfoRepository.findAll();
	}
	
	/**
	 * 增加新用户
	 * @param name
	 * @return
	 */
	@GetMapping("/userinfo/{name}")
	public UserInfo addUserInfo(@PathVariable String name){
		UserInfo userInfo = new UserInfo();
		userInfo.setName(name);
		return userInfoRepository.save(userInfo);
	}
	
	/**
	 * 增加新用户后再立即查找该用户信息
	 * @param name
	 * @return
	 */
	@GetMapping("/userinfo/wr/{name}")
	public UserInfo writeAndRead(@PathVariable String name) {
		UserInfo userInfo = new UserInfo();
		userInfo.setName(name);
		userInfoRepository.saveAndFlush(userInfo);
        Optional<UserInfo> byId = userInfoRepository.findById(userInfo.getId());
        return byId.get();
	}
}
