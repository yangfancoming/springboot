package A04_synchronize.example01;



/**
 * Created by 64274 on 2018/7/20.
 *
 * @author 山羊来了
 * @Description: TODO
 * @date 2018/7/20---13:25
 *

 */
public class MyTask3 implements Runnable {
    private   int tickets = 50;
    @Override
    public void run() {
        while (true){
            gaga();
        }
    }

    private synchronized void gaga(){
        //该方法 一次只能有一个线程进入
        if(tickets>0){
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(Thread.currentThread().getName() + "抢到了" + tickets--);
        }
    }

}
