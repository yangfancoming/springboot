package com.goat.service;

import com.goat.annotation.Log;
import com.goat.domain.MyMoney;
import org.springframework.retry.annotation.Backoff;
import org.springframework.retry.annotation.Retryable;
import org.springframework.scheduling.annotation.Async;
import org.springframework.scheduling.annotation.AsyncResult;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.concurrent.Future;


/**
 * Created by 64274 on 2018/9/14.
 *
 * @author 山羊来了
 * @Description: TODO
 * @date 2018/9/14---16:17
 */
@Service
public class TestService2 extends OtherService{

    @Log(title = "日志模块 函数")
    @Async("asyncTaskExecutor")
    @Retryable(value = {RuntimeException.class},  backoff = @Backoff(delay = 1500L, multiplier = 1))
    public void saveAll2(List<MyMoney> lists,String code) { //
        super.saveAll2(lists,code);
        System.out.println(Thread.currentThread().getName()+"111111111111111111111111111111111111");
    }

    @Log(title = "天堂模块 函数")
    @Async("asyncTaskExecutor")
    @Retryable(value = {RuntimeException.class},  backoff = @Backoff(delay = 1500L, multiplier = 1))
    public Future<List<MyMoney>> saveAll21(List<MyMoney> lists, String code) { //
        List<MyMoney> myMonies = super.saveAll22(lists, code);
        System.out.println(Thread.currentThread().getName()+"222222222222222222222222222222222222");
        return new AsyncResult<>(myMonies);
    }


}

