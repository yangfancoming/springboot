package A04_synchronize.example01;



/**
 * Created by 64274 on 2018/7/20.
 *
 * @author 山羊来了
 * @Description: 卖票 售票  电影票 示例
 * @date 2018/7/20---13:25
 *
 */
public class MyTask1 extends MyTaskTemplate implements Runnable {

    private int tickets = 50;

    @Override
    public void run() {
        while (true){
            if(tickets<=0){
                break;
            }
            test(tickets);
            System.out.println(Thread.currentThread().getName() + "抢到了" + tickets--);
        }
    }
}
