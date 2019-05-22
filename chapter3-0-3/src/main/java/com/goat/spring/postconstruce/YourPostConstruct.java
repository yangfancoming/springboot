package com.goat.spring.postconstruce;

import org.springframework.stereotype.Component;

@Component
public class YourPostConstruct {

    public void sayHello() {
        System.out.println("hello, i am yourPostConstruct");
    }
}
