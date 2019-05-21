package com.goat.spring.beanscope;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;

@Component
public class MyScopeTest1 {

    @Autowired  MyScope myScope;
    @Autowired  MyScopePrototype myScopePrototype;


    @PostConstruct
    public void sayMyScope() {
        System.out.println("hello,i am MyScopeTest1, my scope is " + myScope.toString());
        System.out.println("hello,i am MyScopeTest1, my myScopePrototype is " + myScopePrototype.toString());
    }
}
