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
         * @Param: value:指定发生的异常进行重试
         * @Param: maxAttempts 最大重试次数 默认 3
         * @Param: backoff 重试补偿机制，默认没有
         * @Return:
         * @Date:   2018/12/4
    */
    @Retryable(value = {RemoteAccessException.class}, maxAttempts = 4, backoff = @Backoff(delay = 500l, multiplier = 1))
    public void retry() {
        logger.info(LocalTime.now() + " 执行业务操作...");
        throw new RemoteAccessException("RPC调用异常");
    }

    // @Retryable注解方法返回值是void，@Recover才会生效
    @Recover
    public void recover(RemoteAccessException e) {
        logger.info(e.getMessage());
    }
}
