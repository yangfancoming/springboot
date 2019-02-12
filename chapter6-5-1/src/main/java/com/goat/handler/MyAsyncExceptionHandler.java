package com.goat.handler;

import com.goat.config.TaskExecutorPoolConfig;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.aop.interceptor.AsyncUncaughtExceptionHandler;
import org.springframework.stereotype.Component;

import java.lang.reflect.Method;

/**
 * Created by 64274 on 2019/2/12.
 * sos 这种方式 只能拦截到 没有返回值的 带有@Async的异步方法，由返回值的 则无法拦截，控制台也不会报错
 * @ Description:  自定义异常处理类  对于Spring @Async注解的方法，进行异常处理的类
 * @ author  山羊来了
 * @ date 2019/2/12---21:58
 */
@Component
public class MyAsyncExceptionHandler implements AsyncUncaughtExceptionHandler {

    private static final Logger log = LoggerFactory.getLogger(MyAsyncExceptionHandler.class);

    @Override
    public void handleUncaughtException(Throwable throwable, Method method, Object... obj) {
        log.info("山羊来了 Exception message - " + throwable.getMessage());
        log.info("Method name - " + method.getName());
        for (Object param : obj) {
            log.info("Parameter value - " + param);
        }
    }
}
