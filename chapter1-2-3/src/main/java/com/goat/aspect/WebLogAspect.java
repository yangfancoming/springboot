package com.goat.aspect;

import com.goat.model.Foo;
import org.apache.log4j.Logger;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;

import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;
import java.util.Arrays;


@Aspect
@Order(5)
@Component
public class WebLogAspect {

    private Logger logger = Logger.getLogger(getClass());

    ThreadLocal<Long> startTime = new ThreadLocal<>();

    @Pointcut("execution(public * com.goat.web..*.*(..))")
    public void webLog(){}

    @Before("webLog()")
    public void doBefore(JoinPoint joinPoint) {
        startTime.set(System.currentTimeMillis());
        // 接收到请求，记录请求内容
        ServletRequestAttributes attributes = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
        HttpServletRequest request = attributes.getRequest();
        // 记录下请求内容
        logger.info("URL : " + request.getRequestURL().toString());
        logger.info("HTTP_METHOD : " + request.getMethod());
        logger.info("IP : " + request.getRemoteAddr());
        logger.info("CLASS_METHOD : " + joinPoint.getSignature().getDeclaringTypeName() + "." + joinPoint.getSignature().getName());
        logger.info("ARGS : " + Arrays.toString(joinPoint.getArgs()));

    }
    /**
     2019-03-14 14:45:18,174  INFO WebLogAspect:38 - URL : http://localhost:8123/hello
     2019-03-14 14:45:18,178  INFO WebLogAspect:39 - HTTP_METHOD : GET
     2019-03-14 14:45:18,178  INFO WebLogAspect:40 - IP : 0:0:0:0:0:0:0:1
     2019-03-14 14:45:18,183  INFO WebLogAspect:41 - CLASS_METHOD : com.goat.web.HelloController.hello
     2019-03-14 14:45:18,184  INFO WebLogAspect:42 - ARGS : [goat]
     2019-03-14 14:45:20,999  INFO WebLogAspect:50 - RESPONSE : Hello goat123
     2019-03-14 14:45:21,000  INFO WebLogAspect:51 - SPEND TIME : 2827

     页面 接收到 controller的返回值 是 Hello goat 说明 @AfterReturning 修改返回值 并有影响 controller的返回值
    */

//    @AfterReturning(returning = "ret", pointcut = "webLog()")
//    public void doAfterReturning(Object ret) {
//        ret = ret + "123";
//        // 处理完请求，返回内容
//        logger.info("RESPONSE : " + ret);
//        logger.info("SPEND TIME : " + (System.currentTimeMillis() - startTime.get()));
//    }


    /**  但是 对于 实体类 来说 就不一样了！ 更改 实体类的属性后
     页面 接收到 controller的返回值 是 更改后的 返回值 {"name":"goat","age":123445}
     */
    @AfterReturning(returning = "ret", pointcut = "webLog()")
    public void doAfterReturning(Object ret) {
        Foo temp = (Foo) ret;
        temp.setAge(123445);
        // 处理完请求，返回内容
        logger.info("RESPONSE : " + temp);
        logger.info("SPEND TIME : " + (System.currentTimeMillis() - startTime.get()));
    }

}

