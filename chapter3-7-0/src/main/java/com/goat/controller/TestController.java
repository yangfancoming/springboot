package com.goat.controller;

import com.goat.bean.Account;
import com.goat.utils.JwtUtil;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletResponse;
import java.util.HashMap;

/**
 * Created by 64274 on 2018/11/20.
 *
 * @author 山羊来了
 * @Description: TODO
 * @date 2018/11/20---15:09
 */

@RestController
public class TestController {


    // http://localhost:8370/api/protected
    @GetMapping("/api/protected")
    public Object hellWorld() {
        return "Hello World! This is a protected api";
    }

    // http://localhost:8370/
    @PostMapping("/login")
    public Object login(HttpServletResponse response, @RequestBody final Account account) {

        if(account.getUsername().equals("admin") && account.getPassword().equals("123")){
            String jwt = JwtUtil.generateToken(account.username,"ThisIsASecret");
            return new HashMap<String,String>(){{
                put("token", jwt);
            }};
        }else {
            return new ResponseEntity(HttpStatus.UNAUTHORIZED);
        }

    }
}
