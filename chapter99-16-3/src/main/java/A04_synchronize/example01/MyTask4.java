package A04_synchronize.example01;


import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * Created by 64274 on 2018/7/20.
 *
 * @author 山羊来了
 * @Description: TODO
 * @date 2018/7/20---13:25
 */
public class MyTask4 extends MyTaskTemplate implements Runnable {

    private int tickets = 50;

    private Lock lock = new ReentrantLock();

    @Override
    public void run() {
        long startTime=System.currentTimeMillis();
        while (true){
            lock.lock();
            if(tickets<=0){
                break;
            }
            sleep();
            System.out.println(Thread.currentThread().getName() + "抢到了" + tickets--);
            lock.unlock();
        }
        long endTime=System.currentTimeMillis();
        cacul(startTime,endTime);
    }

}
