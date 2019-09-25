package com.goat.C.C05.item00;

public abstract class MyHandler {

	private MyHandler mSuccessor;


    public MyHandler() {
        System.out.println("MyHandler 构造函数执行");
    }

	/**
     * @Description:  责任链最经典的地方
     * @author: Goat
     * @param successor   继承者 用于存储下一个责任链节点
     * @return successor  设置谁就返回谁
     * @Date:   2018/11/1
	*/
	public MyHandler setSuccessor(MyHandler successor) {
		this.mSuccessor = successor;
		return successor; // 重点在这里 返回的是 当前传入的对象 而不是this 所以才能组成一个链
//		return this; // 如果是 返回this 则只有第一个和最后一个被调用  运行 test0 体会一下
	}
	
	public abstract void handleRequest(int request);

    void test(int request){
        if (mSuccessor != null) {
            System.out.println(this.getClass().getName() + "类 接收请求："+ request + " -- 不归我管，交给下一个");
            mSuccessor.handleRequest(request);
        }else {
            System.out.println(this.getClass().getName() + "  没有人能管！ 责任链结束！");
        }
    }
}
