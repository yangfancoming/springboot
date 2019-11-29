package com.goat.chapter306.buzz;


public class HelloWorldServiceImpl implements HelloWorldService {

    @Override
    public void helloWorld(String msg) {
        System.out.println(msg);
    }
}
