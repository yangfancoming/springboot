package com.goat.exception;


import org.springframework.dao.DuplicateKeyException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.io.IOException;


/**
 * 通过使用@ControllerAdvice定义统一的异常处理类，而不是在每个Controller中逐个定义。
 * @ExceptionHandler用来定义函数针对的异常类型
 优点：将 Controller 层的异常和数据校验的异常进行统一处理，减少模板代码，减少编码量，提升扩展性和可维护性。
 缺点：只能处理 Controller 层未捕获（往外抛）的异常，对于 Interceptor（拦截器）层的异常，Spring 框架层的异常，就无能为力了。

 */

@ControllerAdvice // 该注解定义全局异常处理类  请确保此 GlobalExceptionHandler 类能被扫描到并装载进 Spring 容器中
public class GlobalExceptionHandler {

    /**  处理自定义异常*/
    @ExceptionHandler(MyException.class)
    @ResponseBody
    public void myException(HttpServletRequest req, MyException e)  {
        System.out.println(e.getMessage()+ ".............MyException");
    }

    /**  处理IO 异常*/
    @ExceptionHandler(IOException.class)
    @ResponseBody
    public void iOException(IOException e) {
        System.out.println(e.getMessage()+ ".............IOException");
    }

    /**  处理 DuplicateKeyException 异常*/
    @ExceptionHandler(DuplicateKeyException.class)
    @ResponseBody
    public void duplicateKeyException(DuplicateKeyException e) {
        System.out.println(e.getCause().getMessage()+ ".............DuplicateKeyException");
    }


    /**  处理 RuntimeException 异常*/
    @ExceptionHandler(RuntimeException.class)
    @ResponseBody
    public void runtimeException(RuntimeException e) {
        System.out.println(e.getCause().getMessage()+ ".............RuntimeException");
    }

    //    方法 defaultErrorHandler() 就会处理所有 Controller 层抛出的 Exception 及其子类的异常，这是最基本的用法了
    @ExceptionHandler(value = Exception.class)
    public void defaultErrorHandler(HttpServletRequest req, Exception e) {
        System.out.println(e.getMessage()+ ".............Exception");
    }
//
}

