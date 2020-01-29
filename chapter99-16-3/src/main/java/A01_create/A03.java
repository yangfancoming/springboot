package A01_create;


import org.junit.Test;

public class A03 {


    public static class MyThread extends Thread{
        @Override
        public void run() {
            for (int i = 0; i < 10; i++) {
                System.out.println("MyThread --> start()");
            }
        }
    }

    public static class MyRunnable implements Runnable{
        @Override
        public void run() {
            for (int i = 0; i < 10; i++) {
                System.out.println("MyRunnable --> start()");
            }
        }
    }


    /**
     * @Description: ：继承 Thread 的对象  可以直接使用 start() 的方式 启动线程
     * @author: Goat
     * @Date:   2018/8/31
     */
    @Test
    public void test(){
        MyThread myThread = new MyThread();
        myThread.start();
    }

    /**
     * @Description: ：实现 Runnable 接口的对象  只能使用 代理方式 启动线程
     * @author: Goat
     * @Date:   2018/8/31
     */
    @Test
    public void test1(){
        MyRunnable myThread = new MyRunnable();
        new Thread(myThread).start();
    }

    // 多运行几遍 代码的执行是概率性的
    public static void main(String[] args) {

        MyThread myThread1 = new MyThread();
        myThread1.start();

        MyRunnable myThread2 = new MyRunnable();
        new Thread(myThread2).start();

        for (int i = 0; i < 10; i++) {
            System.out.println("一遍敲代码。。。。。");
        }
    }


}
