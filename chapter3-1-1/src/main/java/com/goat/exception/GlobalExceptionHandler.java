package com.goat.exception;


import org.hibernate.StaleObjectStateException;
import org.springframework.dao.DuplicateKeyException;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;


/**
 * 通过使用@ControllerAdvice定义统一的异常处理类，而不是在每个Controller中逐个定义。
 * @ExceptionHandler 用来定义函数针对的异常类型
 优点：将 Controller 层的异常和数据校验的异常进行统一处理，减少模板代码，减少编码量，提升扩展性和可维护性。
 缺点：只能处理 Controller 层未捕获（往外抛）的异常，对于 Interceptor（拦截器）层的异常，Spring 框架层的异常，就无能为力了。
 @RestControllerAdvice 类似于 @RestController 与 @Controller的区别
 */

//@ControllerAdvice // 该注解定义全局异常处理类  请确保此 GlobalExceptionHandler 类能被扫描到并装载进 Spring 容器中
@ControllerAdvice(annotations = RestController.class) //  指定 拦截 带有 @RestController 注解的 controller 触发的异常。 eg: HelloController 中的除零异常就不能捕获
@ResponseBody
public class GlobalExceptionHandler {

    /**  处理自定义异常*/
    @ExceptionHandler(MyException.class)
    public void myException(HttpServletRequest req, MyException e)  {
        System.out.println(e.getMessage()+ "统一捕获全局异常.............MyException");
    }

    @ExceptionHandler(SQLException.class)
    public void handleSQLException(HttpServletRequest request, Exception e) {
        System.out.println(e.getMessage()+ "统一捕获全局异常.............SQL异常");
    }

    @ResponseStatus(HttpStatus.NOT_FOUND)
    @ExceptionHandler(NotFoundException.class)
    public void handleNotFoundException(NotFoundException e) {
        System.out.println(e.getMessage()+ "统一捕获全局异常............."+ HttpStatus.NOT_FOUND.value());
    }

    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(BadRequestException.class)
    public void handleBadRequestException(BadRequestException e) {
        System.out.println(e.getMessage()+ "统一捕获全局异常............."+ HttpStatus.BAD_REQUEST.value());
    }

    /**  处理IO 异常*/
    @ExceptionHandler(IOException.class)
    public void iOException(IOException e) {
        System.out.println(e.getMessage()+ "统一捕获全局异常.............IOException");
    }

    /**  处理 DuplicateKeyException 异常*/
    @ExceptionHandler(DuplicateKeyException.class)
    public void duplicateKeyException(DuplicateKeyException e) {
        System.out.println(e.getCause().getMessage()+ "统一捕获全局异常.............DuplicateKeyException");
    }


    /**  处理 RuntimeException 异常*/
    @ExceptionHandler(RuntimeException.class)
    public void runtimeException(RuntimeException e) {
        System.out.println(e.getCause().getMessage()+ "统一捕获全局异常.............RuntimeException");
    }

    //    方法 defaultErrorHandler() 就会处理所有 Controller 层抛出的 Exception 及其子类的异常，这是最基本的用法了
    @ExceptionHandler(value = Exception.class)
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    public void defaultErrorHandler(HttpServletRequest req, Exception e) {
        System.out.println(e.getMessage()+ "统一捕获全局异常.............Exception");
        if (e instanceof MyException) {
            MyException ze = (MyException) e;
            System.out.println(e.getMessage()+"这里还可以判断类型的哦");
        }
    }

    /**   处理 JPA @Version 乐观锁 异常  详情见： chapter4-2-0  JpaTestController */
    @ExceptionHandler(StaleObjectStateException.class)
    public void iOException(StaleObjectStateException e) {
        System.out.println(e.getMessage()+ "统一捕获全局异常.............StaleObjectStateException");
    }

    @ExceptionHandler(UserNotExistException.class)
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    public Map<String, Object> handleUserNotExistsException(UserNotExistException e) {
        Map<String, Object> map = new HashMap<>();
        map.put("id", e.getId());
        map.put("message", e.getMessage());
        return map;
    }

}

