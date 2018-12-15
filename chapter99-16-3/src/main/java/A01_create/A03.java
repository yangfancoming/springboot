package A01_create;

import org.testng.annotations.Test;

public class A03 {

    public class MyRunnable implements Runnable{
        @Override
        public void run() {
            System.out.println("MyRunnable --> run()");
        }
    }
    public class MyThread extends Thread{
        @Override
        public void run() {
            System.out.println("MyThread --> run()");
        }
    }
        /**
         * @Description: ：继承 Thread 的对象  可以直接使用 start() 的方式 启动线程
         * @author: 杨帆
         * @Date:   2018/8/31
         */
        @Test
        public void test(){
            MyThread myThread = new MyThread();
            myThread.start();
        }
        /**
         * @Description: ：实现 Runnable 接口的对象  只能使用 代理方式 启动线程
         * @author: 杨帆
         * @Date:   2018/8/31
         */
        @Test
        public void test1(){
            MyRunnable myThread = new MyRunnable();
            new Thread(myThread).start();
        }


}
