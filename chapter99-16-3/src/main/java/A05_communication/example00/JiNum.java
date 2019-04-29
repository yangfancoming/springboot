package A05_communication.example00;

/**
 * Created by 64274 on 2019/4/29.
 *
 * @ Description: 奇数线程
 * @ author  山羊来了
 * @ date 2019/4/29---13:20
 */
public  class JiNum implements Runnable {

    private TwoThreadWaitNotify number;

    public JiNum(TwoThreadWaitNotify number) {
        this.number = number;
    }

    @Override
    public void run() {

        while (number.start <= 10) {
            synchronized (TwoThreadWaitNotify.class) {
                System.out.println("奇数线程抢到锁了");
                if (!number.flag) {
                    System.out.println(Thread.currentThread().getName() + "+-+奇数" + number.start);
                    number.start++;
                    number.flag = true;
                    TwoThreadWaitNotify.class.notify();
                }else {
                    try {
                        TwoThreadWaitNotify.class.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        }
    }
}
