package com.goat.api;

import org.springframework.http.ResponseEntity;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.User;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class UserController {

	// 资源API   http://localhost:3641/api/userinfo  如果没有token 则提示： Full authentication is required to access this resource  <unauthorized>
    @RequestMapping("/api/userinfo")
    @CrossOrigin
    public ResponseEntity<UserInfo> getUserInfo() {
        User user = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        UserInfo userInfo = new UserInfo(user.getUsername(),user.getUsername() + "@spring2go.com");
        return ResponseEntity.ok(userInfo);
    }

}