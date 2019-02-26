package com.goat.service;

import com.goat.annotation.Log;
import com.goat.domain.MyMoney;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.retry.annotation.Backoff;
import org.springframework.retry.annotation.Retryable;
import org.springframework.scheduling.annotation.Async;
import org.springframework.scheduling.annotation.AsyncResult;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.concurrent.Future;


/**
 * Created by 64274 on 2018/9/14.
 *
 * @author 山羊来了
 * @Description: TODO
 * @date 2018/9/14---16:17
 */
@Component
//public class TestService2 extends OtherService { //
public class TestService2 {

    @Autowired OtherService otherService;
    @Log(title = "日志模块 函数")
    @Async("asyncTaskExecutor")
    @Retryable(value = {RuntimeException.class},  backoff = @Backoff(delay = 1500L, multiplier = 1))
    public void saveAll2(List<MyMoney> lists,String code) { //
        otherService.saveAll2(lists,code);
        System.out.println(Thread.currentThread().getName()+"111111111111111111111111111111111111");
    }

    /**  该方法带返回值 为啥就不能回滚了？？？ 上面的不带返回值的方法 为啥就能回滚呢？？？
     * sos  因为 使用 继承 public class TestService2 extends OtherService 的方式来  调用 OtherService中的  saveAll22() 方法
     * 导致 该方法触发的异常 不能够回滚
     * 解决方法：去掉 extends 继承  直接注入Service  @Autowired OtherService otherService;

    */
    @Log(title = "天堂模块 函数")
    @Async("asyncTaskExecutor")
    @Retryable(value = {RuntimeException.class},  backoff = @Backoff(delay = 1500L, multiplier = 1))
    public Future<List<MyMoney>> saveAll21(List<MyMoney> lists, String code) { //
        List<MyMoney> myMonies = otherService.saveAll22(lists, code);
        System.out.println(Thread.currentThread().getName()+"222222222222222222222222222222222222");
        return new AsyncResult<>(myMonies);
    }

//    @Log(title = "天堂模块 函数")
//    @Async("asyncTaskExecutor")
//    @Retryable(value = {RuntimeException.class},  backoff = @Backoff(delay = 1500L, multiplier = 1))
//    public Future<List<MyMoney>> saveAll21(List<MyMoney> lists, String code) { //
//        List<MyMoney> myMonies = super.saveAll22(lists, code);
//        System.out.println(Thread.currentThread().getName()+"222222222222222222222222222222222222");
//        return new AsyncResult<>(myMonies);
//    }

}

