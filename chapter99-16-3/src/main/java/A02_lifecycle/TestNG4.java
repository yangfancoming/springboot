package A02_lifecycle;

import org.testng.annotations.Test;

/**
     * @Description: 功能描述：( 线程的各种状态 )
     * @author: 杨帆
     * @Param:
     * @Return:
     * @Date:   2018/8/29
*/

public class TestNG4 {

    public class ThreadState implements Runnable {

        public synchronized void waitForASecond() throws InterruptedException {
            wait(500); // 使当前线程等待0.5秒或其他线程调用notify()或notifyAll()方法
        }

        public synchronized void waitForYears() throws InterruptedException {
            wait(); // 使当前线程永久等待，直到其他线程调用notify()或notifyAll()方法
        }

        public synchronized void notifyNow() throws InterruptedException {
            notify(); // 唤醒由调用wait()方法进入等待状态的线程
        }

        public void run() {
            try {
                waitForASecond(); // 在新线程中运行waitForASecond()方法
                waitForYears(); // 在新线程中运行waitForYears()方法
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    @Test
    public void test() throws InterruptedException {
        ThreadState state = new ThreadState();// 创建State对象

        Thread thread = new Thread(state);// 利用State对象创建Thread对象
        System.out.println("新建线程：" + thread.getState());// 输出线程状态

        thread.start(); // 调用thread对象的start()方法，启动新线程
        System.out.println("启动线程：" + thread.getState());// 输出线程状态

        Thread.sleep(100); // 当前线程休眠0.1秒，使新线程运行waitForASecond()方法
        System.out.println("计时等待：" + thread.getState());// 输出线程状态


        Thread.sleep(1000); // 当前线程休眠1秒，使新线程运行waitForYears()方法
        System.out.println("等待线程：" + thread.getState());// 输出线程状态


        state.notifyNow(); // 调用state的notifyNow()方法
        System.out.println("唤醒线程：" + thread.getState());// 输出线程状态

        Thread.sleep(1000); // 当前线程休眠1秒，使新线程结束
        System.out.println("终止线程：" + thread.getState());// 输出线程状态
    }
}
