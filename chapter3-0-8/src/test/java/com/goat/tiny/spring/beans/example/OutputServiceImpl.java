package com.goat.tiny.spring.beans.example;


public class OutputServiceImpl implements OutputService {

    private HelloWorldService helloWorldService;

    @Override
    public void output(String text){
        System.out.println(text);
    }

//    public void setHelloWorldService(HelloWorldService helloWorldService) {
//        this.helloWorldService = helloWorldService;
//    }
}
