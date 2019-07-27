
package com.goat.A.A03.example01;

import org.junit.Test;


public class App {

    /** 单例地址测试  证明了单例  */
    @Test
    public void test1(){
        Emperor emperor1 = Emperor.getInstance();
        Emperor emperor2 = Emperor.getInstance();
        System.out.println(emperor1); // com.goat.A.A03.example01.Emperor@782830e
        System.out.println(emperor2); // com.goat.A.A03.example01.Emperor@782830e
        System.out.println(emperor1 == emperor2); // true
        System.out.println(emperor1.equals(emperor2) );  // true
    }

    /** 单线程测试： 可以看到 for循环 输出的 emperor 地址都是一样的 */
    @Test
    public void test(){
        for (int day = 0; day < 3; day++) {
            Emperor emperor = Emperor.getInstance();
            emperor.say();
            System.out.println(emperor);
        }
    }



    /** 多线程测试： 可以看到 for循环 输出的 emperor 地址都是一样的  由于是天然的线程安全 所以在多线程的情况下 该单例也是安全的*/
    public static void main(String[] args) {

        for (int i = 0; i < 10; i++) {
            new Thread(()->{
                Emperor instance = Emperor.getInstance();
                System.out.println(instance);
            },String.valueOf(i)).start();
        }
    }

}
