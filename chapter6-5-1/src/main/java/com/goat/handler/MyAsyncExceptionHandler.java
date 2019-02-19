package com.goat.handler;

import com.goat.service.HelloService;
import com.goat.service.TestService;
import com.goat.utils.SpringContextUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.aop.interceptor.AsyncUncaughtExceptionHandler;
import org.springframework.beans.factory.annotation.Autowired;
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

    @Autowired
    TestService testService;

    @Autowired
    HelloService helloService;
    public void test(){
        testService.sayHi();
    }

//    @Override
    public void handleUncaughtException(Throwable throwable, Method method, Object... obj) {
        log.info("进入自定义 错误 handler  Exception message - " + throwable.getMessage());
        log.info("Method name - " + method.getName());
        for (Object param : obj) {
            log.info("Parameter value - " + param);
        }
        TestService testService = (TestService) SpringContextUtil.getBean("testService");
        testService.sayHi();
        helloService.hello(); // 为 null
        /**  在 自定义异常中 获取 报错函数的信息 报错获取函数头上的注解 @Log
     Log myLog = null;
     if (method != null){ // 是否存在注解，如果存在就获取
     myLog = method.getAnnotation(Log.class);
     }

     if (myLog == null) return;
     OperLog operLog = new OperLog();
     operLog.setAction(myLog.action()); // 设置action动作
     operLog.setTitle(myLog.title()); // 设置标题
     operLog.setOperTime(new Date()); // 设置操作时间
    */
    }
}
