
package com.goat.A.A03.example02;

/**  懒汉式
 *  1. 在类加载时 并不创建，只在第一次使用时 才创建！
 *  2. 私有化 构造函数
 *
 *  懒汉式单例的线程安全问题，由于 emperor 是类属性变量，它是线程不安全的，并发环境下很可能出现多个 emperor 实例，要实现线程安全，有以下三种方式，都是对getInstance这个方法改造，保证了懒汉式单例的线程安全
 */
public class Emperor {

	private static  Emperor emperor ;

	private Emperor(){
        System.out.println("2222哥是 懒汉式 构造方法！");
	}

	public static Emperor getInstance(){
        if (emperor == null){
            emperor = new Emperor(); // 引出线程安全问题：  并不是在类加载时就创建  而是程序在运行中动态创建的 所以存在线程安全问题
        }
		return emperor;
	}

    public static synchronized Emperor getInstance1(){
        if (emperor == null){
            emperor = new Emperor(); //解决方式1： synchronized 方法锁  解决线程安全问题  效率较低
        }
        return emperor;
    }

    public static  Emperor getInstance2(){
        if (emperor == null){
            synchronized (Emperor.class){
                if (emperor == null){
                    emperor = new Emperor();  //解决方式2： synchronized 代码块锁 需要双重检查锁定  解决线程安全问题  效率较高  但是存在 指令重排带来的 安全隐患
                }
            }
        }
        return emperor;
    }

	//皇帝发话了
	public static void say(){
		System.out.println("我就是皇帝某某某....");		
	}
}
