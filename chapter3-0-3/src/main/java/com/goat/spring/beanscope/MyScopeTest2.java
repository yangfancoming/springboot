package com.goat.spring.beanscope;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;

@Component
public class MyScopeTest2 {

    @Autowired  MyScope myScope;
    @Autowired  MyScopePrototype myScopePrototype;


    @PostConstruct // 备注：Bean初始化时候的执行顺序： 构造方法 -> @Autowired -> @PostConstruct  参见控制台打印信息
    public void sayMyScope() {
        System.out.println("hello,i am MyScopeTest2, my scope is " + myScope.toString());
        System.out.println("hello,i am MyScopeTest2, my myScopePrototype is " + myScopePrototype.toString());
    }
}
