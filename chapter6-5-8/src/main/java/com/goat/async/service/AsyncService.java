package com.goat.async.service;

import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Component;

import java.text.SimpleDateFormat;

/**
 * Created by 64274 on 2019/3/19.
 *
 * @ Description: TODO
 * @ author  山羊来了
 * @ date 2019/3/19---21:44
 */

@Component
public class AsyncService {

    @Async("asyncTaskExecutor")
    public void test(){
        SimpleDateFormat aDate=new SimpleDateFormat("yyyy-mm-dd  HH:mm:ss");
        long now= System.currentTimeMillis(); // 当前系统时间
        System.out.println(Thread.currentThread().getName() +"-------------"+ aDate.format(now));
    }

}
