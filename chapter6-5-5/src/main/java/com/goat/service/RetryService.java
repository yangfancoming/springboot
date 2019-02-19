package com.goat.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.remoting.RemoteAccessException;
import org.springframework.retry.annotation.Backoff;
import org.springframework.retry.annotation.Recover;
import org.springframework.retry.annotation.Retryable;
import org.springframework.stereotype.Service;

import java.time.LocalTime;

@Service
public class RetryService {
    private final static Logger logger = LoggerFactory.getLogger(RetryService.class);

    /**
         * @Description: 功能描述：(这里用一句话描述这个方法的作用)
         * @author: 杨帆
         * @Param: value:发生指定的异常时进行重试
         * @Param: maxAttempts 最大重试次数 默认 3
         * @Param: backoff 重试补偿机制，默认没有
         * @Param: delay  每次重试的时间间隔
         * @Param: multiplier 指定延迟的倍数，比如delay=5000l,multiplier=2时，第一次重试为5秒后，第二次为10秒，第三次为20秒
         * @Return:
         * @Date:   2018/12/4
    */
    @Retryable(value = {RemoteAccessException.class}, maxAttempts = 4, backoff = @Backoff(delay = 500L, multiplier = 1))
    public void retry() {
        logger.info(LocalTime.now() + " 执行业务操作...");
        throw new RemoteAccessException("RPC调用异常");
    }

    // @Retryable注解方法返回值是void，@Recover才会生效
    @Recover // 当重试到达指定次数时，被注解的方法将被回调，可以在该方法中进行日志处理。需要注意的是发生的异常和入参类型一致时才会回调
    public void recover(RemoteAccessException e) {
        logger.info(e.getMessage());
        logger.info("@Recover 执行............................. ");
    }
}
