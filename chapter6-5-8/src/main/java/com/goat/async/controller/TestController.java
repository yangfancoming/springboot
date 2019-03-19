package com.goat.async.controller;

import com.goat.async.service.AsyncService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by 64274 on 2019/3/19.
 *
 * @ Description: TODO
 * @ author  山羊来了
 * @ date 2019/3/19---21:55
 */
@RestController
public class TestController {


    @Autowired
    AsyncService asyncService;
    //   http://localhost:8658/test

    /** 可以看到 这里是 多线程执行的
     asyncTaskExecutor2-------------2019-14-19  22:14:35
     asyncTaskExecutor3-------------2019-14-19  22:14:35
     asyncTaskExecutor5-------------2019-14-19  22:14:35
     asyncTaskExecutor1-------------2019-14-19  22:14:35
     asyncTaskExecutor4-------------2019-14-19  22:14:35
     asyncTaskExecutor2-------------2019-14-19  22:14:35
     asyncTaskExecutor3-------------2019-14-19  22:14:35
     asyncTaskExecutor5-------------2019-14-19  22:14:35
     asyncTaskExecutor1-------------2019-14-19  22:14:35
     asyncTaskExecutor4-------------2019-14-19  22:14:35
    */
    @GetMapping("/test")
    public void rest(){
        for (int i = 0; i < 10; i++) {
            asyncService.test();
        }
    }
}
