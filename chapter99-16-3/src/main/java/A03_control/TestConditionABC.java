package A03_control;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * 编写一个程序，开启 3 个线程，这三个线程的 ID 分别为
 * A、 B、 C，每个线程将自己的 ID 在屏幕上打印 10 遍，要
 * 求输出的结果必须按顺序显示。
 * 如： ABCABCABC…… 依次递归
 *
 * 通过 Condition 来控制 各个线程间的执行顺序 ( 唤醒哪个 阻塞哪个)
 *
 * doit 为啥  执行完了   System.out.println(Thread.currentThread().getName());//A
 * 后又执行一次 System.out.println("1抢到线程但是等待"); ？？
 */
public class TestConditionABC {


    private int num = 1;

    private static Lock lock = new ReentrantLock();

    private Condition condition1 = lock.newCondition();
    private Condition condition2 = lock.newCondition();
    private Condition condition3 = lock.newCondition();

    public void loopA(){

        lock.lock();
        try {
            if(num != 1){//不等于1 线程1等待 直到被线程3唤醒
                System.out.println("1抢到线程但是等待");
                condition1.await();
            }
            System.out.println(Thread.currentThread().getName());//A
            num = 2;
            condition2.signal();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }finally {
            lock.unlock();
        }
    }

    public void loopB(){

        lock.lock();
        try {
            if(num != 2){
                System.out.println("2抢到线程但是等待");
                condition2.await();
            }
            System.out.println(Thread.currentThread().getName());
            num = 3;
            condition3.signal();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }finally {
            lock.unlock();
        }

    }

    public void loopC(){

        lock.lock();
        try {
            if(num != 3){
                System.out.println("3抢到线程但是等待");
                condition3.await();
            }
            System.out.println(Thread.currentThread().getName());
            num = 1;
            condition1.signal();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }finally {
            lock.unlock();
        }

    }

}

