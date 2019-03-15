package com.goat.aspect;


import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;


/**
     * @Description:
     * @author: 杨帆
     * @Date:   2018/8/23
    整个表达式可以分为五个部分：
    1、execution(): 表达式主体。 execution (* com.sample.service.impl..*.*(..))
    2、第一个* 号：表示返回类型，* 号表示所有的类型。
    3、包名：表示需要拦截的包名，后面的两个句点表示当前包和当前包的所有子包，com.sample.service.impl包、子孙包下所有类的方法。
    4、第二个* 号：表示类名，* 号表示所有的类。
    5、*(..): 最后这个星号表示方法名，* 号表示所有的方法，后面括弧里面表示方法的参数，两个句点表示任何参数。

private static final String aspect =  "execution(* com.goat.con123fig..*(..))";
"execution(* com.goat.test..*(..))"   拦截 test 包下   （.. 当前test包及其所有子包 ）  *(..)中  * 任意方法名  (..) 任意参数

（1）Before ---在所拦截方法执行前执行；
（2）After  ---在所拦截方法执行后执行；
（3）AfterRuturning   ---在所拦截方法返回值后，执行；
（4）AfterThrowing     ---当所拦截方法抛出异常时，执行；
（5）Around ---最为复杂的切入方式，刚方式可以包括上述4个方式。

    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
    Object result;
    try {
    //sos @Before
    result = method.invoke(target, args);
    //sos @After
    return result;
    } catch (InvocationTargetException e) {
    Throwable targetException = e.getTargetException();
    //sos @AfterThrowing
    throw targetException;
    } finally {
    //sos @AfterReturning
    }
    }
*/

@Aspect  // 定义切面
@Component  // 定义组件
public class AspectTest {

    // 定义切入点
    @Before("execution(* com.goat.service..*(..))")
    public void myBefore(){
        System.out.println("哥是前置增强1。。。。。。。。。。。");
    }

    @Before("execution(* com.goat.service..*(..))")
    public void myBefore2(){
        System.out.println("哥是前置增强2。。。。。。。。。。。");
    }

    /**
         * @Description: 功能描述： 拦截指定方法
         * @author: 杨帆
         * @Param:  测试地址：    http://localhost:8341/hello1
         * @Date:   2018/9/26
    */
    @After("execution(* com.goat.service.HelloService.sayHiService1(..))")
    public void myAfter(){
        System.out.println("哥是后置增强。。。。。。。。。。。");
    }


    /**
         * @Description: 功能描述： 后置增强  可以接收 切入方法的返回值
         * @author: 杨帆
         * @Param: 测试地址：    http://localhost:8341/hello1
         * @Return:  rvt
         * @Date:   2018/9/26
    */
    @AfterReturning(returning="rvt", pointcut="execution(* com.goat.service.HelloService.sayHiService1(..))")
    public void afterExec(Object rvt){
        System.out.println("哥是后AfterReturning。。。。。。。。。。。");
        System.out.println(rvt);
    }

    /**
     声明ex时指定的类型会限制目标方法必须抛出指定类型的异常
     此处将ex的类型声明为Throwable，意味着对目标方法抛出的异常不加限制
    */
    @AfterThrowing(throwing="ex",pointcut="execution(* com.goat.service..*(..))")
    public void afterThrowing(Throwable ex){
        System.out.println("哥是 异常增强。。。。。。。。。。。" + ex);
    }


    @Around("execution(* com.goat.service..*(..))")
    public void around(ProceedingJoinPoint pjp){
        System.out.println("哥是 环绕增强1。。。。。。。。。。。");
        System.out.println(pjp.getArgs());
    }

}
