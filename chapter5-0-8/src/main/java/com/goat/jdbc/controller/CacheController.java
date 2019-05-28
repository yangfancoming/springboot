package com.goat.jdbc.controller;

import com.goat.jdbc.service.CacheService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by 64274 on 2019/5/28.
 *
 * @ Description: TODO
 * @ author  山羊来了
 * @ date 2019/5/28---13:07
 */
@RestController
@RequestMapping("cache")
public class CacheController {

    @Autowired
    private CacheService cacheService;


    //    http://localhost:8508/cache/test0
    @GetMapping("test0")
    public void test0() {
        cacheService.cache1();
    }
}
