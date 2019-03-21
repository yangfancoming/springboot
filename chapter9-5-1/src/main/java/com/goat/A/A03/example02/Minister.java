
package com.goat.A.A03.example02;

/**
可以看到 for循环 输出的 emperor 地址都是一样的
 */
public class Minister {

	public static void main(String[] args) {
		for (int day = 0; day < 3; day++) {
			Emperor emperor = Emperor.getInstance();
			emperor.say();
            System.out.println(emperor);
		}
	}

}
