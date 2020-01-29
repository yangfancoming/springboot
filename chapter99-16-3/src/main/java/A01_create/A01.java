package A01_create;


import org.junit.Test;

/**
     * @Description:   线程的创建方式
     * @author: Goat
注意：
    run() 方法相当于普通方法调用，并不创建新的线程
    start() 方法 才会创建新的线程
    即：如果不调用start()方法，那么线程永远不会被启动，在主方法没有调用start()之前，
    Thread对象只是一个实例，而不是一个真正的线程！ 只有start()了之后 才是真正的线程！
     * @Date:   2018/8/29
*/

public class A01 {
    /**
    1）继承Thread类创建线程
    缺点：由于java单继承的限制，一个已经继承了类，则无法再继承Thread类。
    */
    @Test
    public void Thread1(){
        Thread t1 = new Thread(()->System.out.println("pong"));
        t1.setName("t1");
        t1.run();
        System.out.println("ping");
    }

    @Test
    public void Thread2(){
        new Thread(()->System.out.println("pong"),"t2").start();
        System.out.println("ping");
    }

    /**
    2）实现Runnable接口创建线程 ： 推荐使用此种方式创建多线程
    优点：1. 避免了单继承的局限性 2. 便于共享资源
    */

    @Test
    public void Runnable1() {
        Runnable t1 = ()-> System.out.println("pong");
        t1.run(); //  run() 方法相当于普通方法调用，并不创建新的线程
        System.out.println("ping");
    }

    @Test
    public void Runnable2(){
        Runnable t2 = ()-> System.out.println("pong");
        new Thread(t2).start();// start() 方法 才会创建新的线程
        System.out.println("ping");
    }

}
