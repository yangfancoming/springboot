package com.goat.C.C05;

public abstract class MyHandler {

	private MyHandler mSuccessor;

	/**
     * @Description:  责任链最经典的地方
     * @author: 杨帆
     * @param successor   继承者 用于存储下一个责任链节点
     * @return successor  设置谁就返回谁
     * @Date:   2018/11/1
	*/
	public MyHandler setSuccessor(MyHandler successor) {
		mSuccessor = successor;
		return successor;
	}
	
	public abstract void handleRequest(int request);



    void test(int request){
        if (mSuccessor != null) {
            System.out.println(this.getClass().getName() + "不归我管，交给下一个");
            mSuccessor.handleRequest(request);
        }else {
            System.out.println(this.getClass().getName() + "没有人能管！ 责任链结束！");
        }
    }
}
