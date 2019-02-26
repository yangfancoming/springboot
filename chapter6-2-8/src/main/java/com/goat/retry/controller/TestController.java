//package com.goat.retry.controller;
//
//
//
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.statemachine.StateMachine;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RestController;
//
//
//@RestController
//@RequestMapping("/test")
//public class TestController {
//
//    @Autowired
//    private StateMachine<States, Events> stateMachine;
//
//    //    http://localhost:8626/test/test1
//    @RequestMapping("/test1")
//    public void test1()   {
//        stateMachine.start();    //start()就是创建这个订单流程，根据之前的定义，该订单会处于待支付状态，
//    }
//
//    //    http://localhost:8626/test/test2
//    @RequestMapping("/test2")
//    public void test2()   {
//        stateMachine.sendEvent(Events.PAY);    //通过调用sendEvent(Events.PAY)执行支付操作，
//    }
//
//    //    http://localhost:8626/test/test3
//    @RequestMapping("/test3")
//    public void test3()   {
//        stateMachine.sendEvent(Events.RECEIVE);  //通过调用用sendEvent(Events.RECEIVE)来完成收货操作
//    }
//    //    http://localhost:8626/test/test4
//    @RequestMapping("/test4")
//    public void test4()   {
//        stateMachine.stop();  // 停止状态机
//    }
//}
//
//
