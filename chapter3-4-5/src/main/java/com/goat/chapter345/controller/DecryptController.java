package com.goat.chapter345.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by Administrator on 2020/7/10.
 *
 * @ Description: TODO
 * @ author  山羊来了
 * @ date 2020/7/10---20:55
 */

@RestController
@RequestMapping(value = "/api/xx")
public class DecryptController {

    // 加密
    @PostMapping("/encode")
    public void encode(String param1,String param2,String param3) {
        System.out.println(param1);
        System.out.println(param2);
        System.out.println(param3);
    }

    // 解密
    @GetMapping("/decode")
    public void decode() {
        System.out.println("decode");
    }
}
