package com.goat.exception;


import org.hibernate.StaleObjectStateException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;


/**
 * 通过使用@ControllerAdvice定义统一的异常处理类，而不是在每个Controller中逐个定义。
 * @ExceptionHandler 用来定义函数针对的异常类型
 优点：将 Controller 层的异常和数据校验的异常进行统一处理，减少模板代码，减少编码量，提升扩展性和可维护性。
 缺点：只能处理 Controller 层未捕获（往外抛）的异常，对于 Interceptor（拦截器）层的异常，Spring 框架层的异常，就无能为力了。
 */

@ControllerAdvice
public class GlobalExceptionHandler {

    /**  JPA 乐观锁 异常*/
    @ExceptionHandler(StaleObjectStateException.class)
    @ResponseBody
    public void iOException(StaleObjectStateException e) {
        System.out.println(e.getMessage()+ "统一捕获全局异常.............StaleObjectStateException");
    }


}

