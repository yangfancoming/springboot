package com.goat.A.A01.example00;

public class Client {

	public static void main(String[] args) {
		Api api = new Impl(); // 这里 强耦合！ 调用端直接和接口的实现类强关联！
		api.test1("111111111111111111111");
	}
}
