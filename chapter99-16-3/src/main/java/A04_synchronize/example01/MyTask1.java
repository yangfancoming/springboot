package A04_synchronize.example01;



/**
 * Created by 64274 on 2018/7/20.
 *
 * @author 山羊来了
 * @Description: TODO
 * @date 2018/7/20---13:25
 *
 */
public class MyTask1 implements Runnable {
    private int tickets = 50;
    @Override
    public void run() {
        while (true){
            if(tickets<=0){
                break;
            }
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(Thread.currentThread().getName() + "抢到了" + tickets--);
        }

    }
}
