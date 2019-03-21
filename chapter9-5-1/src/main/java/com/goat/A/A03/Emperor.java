
package com.goat.A.A03;

/**
 * 中国的历史上一般都是一个朝代一个皇帝，有两个皇帝的话，必然要PK出一个皇帝出来
 */
public class Emperor {

	private static final Emperor emperor = new Emperor();  //初始化一个皇帝

    // private 构造函数 保证了该类不能被其他类new出来
	private Emperor(){
		//世俗和道德约束你，目的就是不希望产生第二个皇帝
	}

	// 获得唯一一个实例化对象
	public static Emperor getInstance(){
		return emperor;
	}
	
	//皇帝发话了
	public static void say(){
		System.out.println("我就是皇帝某某某....");		
	}
}
