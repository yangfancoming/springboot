package com.goat.task;

import com.goat.service.TestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

/**
 * Created by 64274 on 2019/3/24.
 *
 * @ Description: TODO
 * @ author  山羊来了
 * @ date 2019/3/24---11:47
 */

@Component
public class Task {

    @Autowired
    TestService testService;

    /**
     * 该种方式 无法实现 同时update 导致 触发乐观锁异常 。。。。
    */

    @Scheduled(cron = "5 * * * * ? ")
    public void test1(){
        testService.update2("123",2L,0L);
    }

    @Scheduled(cron = "5 * * * * ? ")
    public void test2(){
        testService.update2("321",2L,0L);
    }


}
