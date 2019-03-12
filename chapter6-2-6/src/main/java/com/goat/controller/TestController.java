package com.goat.controller;



import com.goat.enums.Events;
import com.goat.enums.States;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.statemachine.StateMachine;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/test")
public class TestController {

    @Autowired
    private StateMachine<States, Events> stateMachine;

    //    http://localhost:8626/test/test1
    @RequestMapping("/test1")
    public void test1()   {
        stateMachine.start();    //start()就是创建这个订单流程，根据之前的定义，该订单会处于待支付状态，
    }

    //    http://localhost:8626/test/test2
    @RequestMapping("/test2")
    public void test2()   {
        stateMachine.sendEvent(Events.PAY);    //通过调用sendEvent(Events.PAY)执行支付操作，
    }

    //    http://localhost:8626/test/test3
    @RequestMapping("/test3")
    public void test3()   {
        stateMachine.sendEvent(Events.RECEIVE);  //通过调用用sendEvent(Events.RECEIVE)来完成收货操作
    }

    //    http://localhost:8626/test/test4
    @RequestMapping("/test4")
    public void test4()   {
        stateMachine.stop();  // 停止状态机
    }

    //    http://localhost:8626/test/test5
    @RequestMapping("/test5")
    public void test5()   {
        stateMachine.start();
        stateMachine.sendEvent(Events.PAY);
        stateMachine.sendEvent(Events.RECEIVE);
        stateMachine.stop();  // 停止状态机
    }

    //    http://localhost:8626/test/test6
    @RequestMapping("/test6")
    public void test6()   {

        for (int i = 0; i < 3; i++) {
            stateMachine.start();
            stateMachine.sendEvent(Events.PAY);
            stateMachine.sendEvent(Events.RECEIVE);
            stateMachine.stop();  // 停止状态机
        }
    }
}
/**
 *         stateMachine.start();
 2019-02-26 20:35:44.813  INFO 20076 --- [nio-8626-exec-1] tConfig$$EnhancerBySpringCGLIB$$90ee6463 : 订单创建，待支付
 2019-02-26 20:35:44.822  INFO 20076 --- [nio-8626-exec-1] o.s.s.support.LifecycleObjectSupport     : started org.springframework.statemachine.support.DefaultStateMachineExecutor@4da731a2
 2019-02-26 20:35:44.823  INFO 20076 --- [nio-8626-exec-1] o.s.s.support.LifecycleObjectSupport     : started UNPAID WAITING_FOR_RECEIVE DONE  / UNPAID / uuid=a2c15fb9-5423-4cc2-b69a-f7a5553102e5 / id=null
*/

/**
 *         stateMachine.start();
 *         stateMachine.sendEvent(Events.PAY);
 2019-02-26 20:33:58.850  INFO 8208 --- [nio-8626-exec-1] tConfig$$EnhancerBySpringCGLIB$$846e838d : 订单创建，待支付
 2019-02-26 20:33:58.858  INFO 8208 --- [nio-8626-exec-1] o.s.s.support.LifecycleObjectSupport     : started org.springframework.statemachine.support.DefaultStateMachineExecutor@40241b7
 2019-02-26 20:33:58.858  INFO 8208 --- [nio-8626-exec-1] o.s.s.support.LifecycleObjectSupport     : started UNPAID DONE WAITING_FOR_RECEIVE  / UNPAID / uuid=553c9994-6ad6-492a-b0b5-3db61b3e93ff / id=null
 2019-02-26 20:33:58.862  INFO 8208 --- [nio-8626-exec-1] tConfig$$EnhancerBySpringCGLIB$$846e838d : 用户完成支付，待收货: start
 2019-02-26 20:33:58.863  INFO 8208 --- [nio-8626-exec-1] tConfig$$EnhancerBySpringCGLIB$$846e838d : 用户完成支付，待收货
 2019-02-26 20:33:58.865  INFO 8208 --- [nio-8626-exec-1] tConfig$$EnhancerBySpringCGLIB$$846e838d : 用户完成支付，待收货: end
 */

/**
 *         stateMachine.start();
 *         stateMachine.sendEvent(Events.PAY);
 *         stateMachine.sendEvent(Events.RECEIVE);
 019-02-26 20:36:25.762  INFO 18032 --- [nio-8626-exec-2] tConfig$$EnhancerBySpringCGLIB$$710dfb80 : 订单创建，待支付
 2019-02-26 20:36:25.771  INFO 18032 --- [nio-8626-exec-2] o.s.s.support.LifecycleObjectSupport     : started org.springframework.statemachine.support.DefaultStateMachineExecutor@35ee9311
 2019-02-26 20:36:25.771  INFO 18032 --- [nio-8626-exec-2] o.s.s.support.LifecycleObjectSupport     : started DONE UNPAID WAITING_FOR_RECEIVE  / UNPAID / uuid=b9348f07-8d22-42dc-bd38-164c0c9c6ea4 / id=null
 2019-02-26 20:36:25.777  INFO 18032 --- [nio-8626-exec-2] tConfig$$EnhancerBySpringCGLIB$$710dfb80 : 用户完成支付，待收货: start
 2019-02-26 20:36:25.778  INFO 18032 --- [nio-8626-exec-2] tConfig$$EnhancerBySpringCGLIB$$710dfb80 : 用户完成支付，待收货
 2019-02-26 20:36:25.780  INFO 18032 --- [nio-8626-exec-2] tConfig$$EnhancerBySpringCGLIB$$710dfb80 : 用户完成支付，待收货: end
 2019-02-26 20:36:25.782  INFO 18032 --- [nio-8626-exec-2] tConfig$$EnhancerBySpringCGLIB$$710dfb80 : 用户已收货，订单完成
*/


