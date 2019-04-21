
package com.goat.A.A03.example02;

/**  懒汉式
 *  1. 在类加载时就创建 因此，天然的线程安全
 *  2. 私有化 构造函数
 */
public class Emperor {

	private static  Emperor emperor ;

	private Emperor(){
        System.out.println("2222哥是构造方法！");
	}

//	public static synchronized Emperor getInstance(){
	public static  Emperor getInstance(){
	    if (emperor == null){
	        emperor = new Emperor(); // //初始化一个皇帝  并不是在类加载时就创建  而是程序在运行中动态创建的 所以存在线程安全问题
        }
		return emperor;
	}
	
	//皇帝发话了
	public static void say(){
		System.out.println("我就是皇帝某某某....");		
	}
}
