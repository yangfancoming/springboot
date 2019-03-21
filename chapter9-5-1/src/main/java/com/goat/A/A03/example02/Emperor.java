
package com.goat.A.A03.example02;

/**  懒汉式
 *  1. 在类加载时就创建 因此，天然的线程安全
 *  2. 私有化 构造函数
 */
public class Emperor {

	private static  Emperor emperor ;

	private Emperor(){
	}

	// 外部获取接口  因为该类是在类加载时就创建 因此天然的线程安全，所以在外部获取接口方法上 无需加 synchronized
	public static synchronized Emperor getInstance(){
	    if (emperor == null){
	        emperor = new Emperor();
        }
		return emperor;
	}
	
	//皇帝发话了
	public static void say(){
		System.out.println("我就是皇帝某某某....");		
	}
}
