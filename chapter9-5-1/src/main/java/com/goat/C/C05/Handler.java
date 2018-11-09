package com.goat.C.C05;

public abstract class Handler {

	protected Handler mSuccessor;

	/**
     * @Description:  责任链最经典的地方
     * @author: 杨帆
     * @param successor   继承者 用于存储下一个责任链节点
     * @return successor  设置谁就返回谁
     * @Date:   2018/11/1
	*/
	public Handler setSuccessor(Handler successor) {
		mSuccessor = successor;
		return successor;
	}
	
	public abstract void handleRequest(int request);
}
