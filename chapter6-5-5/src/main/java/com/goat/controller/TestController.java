package com.goat.controller;

import com.goat.service.RetryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by 64274 on 2019/2/19.
 *
 * @ Description: TODO
 * @ author  山羊来了
 * @ date 2019/2/19---9:08
 */
@RestController
public class TestController {

    @Autowired
    private RetryService retryService;
    //  http://localhost:8655/test1
    @GetMapping("/test1")
    public void getAllUsers() {
        retryService.retry();
    }
}
