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

        // 开启第一个线程   第一条路
        MyThread myThread1 = new MyThread();
        myThread1.start();

        // 开启第二个线程   第二条路
        MyRunnable myThread2 = new MyRunnable();
        new Thread(myThread2).start();

        // 主线   第三条路  sos 注意： 如果主线程代码 放在方法体的最前面那么就是 必须要循环10次之后 才会去开辟另外两条路！
        for (int i = 0; i < 10; i++) {
            System.out.println("一遍敲代码。。。。。");
        }
    }


}
