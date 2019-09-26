package com.goat.C.C05.item00;

// 具体处理者类，处理它所负责的请求，可访问它的后继者，如果可处理该请求，则处理，否则转给它的后继者处理
public class ConcrateHandler2 extends MyHandler {

    public ConcrateHandler2() {
        System.out.println("ConcrateHandler2 构造函数执行");
    }

	@Override
	public void handleRequest(int request) {
        if (request >= 10 && request < 20) {
			System.out.println(String.format("%s----我来 处理请求%d", this.getClass().getName(), request));
		} else {
            process(request);
        }
	}
	
}
