package com.goat.concurrency.system.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Random;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

/**
 * Created by 64274 on 2019/5/14.
 *
 * @ Description: BlockingQueue 手动测试
 * @ author  山羊来了
 * @ date 2019/5/14---11:13
 */
@RestController
@RequestMapping("/bq")
public class BlockingQueueController {

    BlockingQueue<Integer> bq = new ArrayBlockingQueue<>(3, true);

    // http://localhost:8901/bq/put
    @GetMapping("/put")
    public void put() throws InterruptedException {
        bq.put(new Random().nextInt(255));
    }

    // http://localhost:8901/bq/take
    @GetMapping("/take")
    public Integer take() throws InterruptedException {
        return  bq.take();
    }

// http://localhost:8901/bq/for
    @GetMapping("/for")
    public void fori()   {
        bq.forEach(s->System.out.println(s));
    }
}
