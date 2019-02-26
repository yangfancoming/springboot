package com.goat.task;

import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Component;

import java.util.UUID;


@Component
public class AsyncTask {

    @Async("asyncTaskExecutor")
    public void test1() {
        System.out.println("f1 : " + Thread.currentThread().getName() + "   " + UUID.randomUUID().toString());
    }


}
