package com.goat.C.C05;

// 具体处理者类，处理它所负责的请求，可访问它的后继者，如果可处理该请求，则处理，否则转给它的后继者处理
public class ConcrateHandler3 extends Handler {

	@Override
	public void handleRequest(int request) {
		if (request >= 20 && request < 30) {
			System.out.println(String.format("%s处理请求%d", this.getClass().getName(), request));
		} else if (mSuccessor != null) {
            System.out.println(this.getClass().getName() + "不归我管，交给下一个");
			mSuccessor.handleRequest(request);
		}else {
            System.out.println(this.getClass().getName() + "没有人能管！ 责任链结束！");
        }
	}
	
}
