package A04_synchronize.example01;



/**
 * Created by 64274 on 2018/7/20.
 *
 * @author 山羊来了
 * @Description: TODO
 * @date 2018/7/20---13:25
 *
 */
public class MyTask1 extends MyTaskTemplate implements Runnable {

    private int tickets = 50;

    @Override
    public void run() {
        long startTime=System.currentTimeMillis();
        while (true){
            if(tickets<=0){
                break;
            }
            test(tickets);
            System.out.println(Thread.currentThread().getName() + "抢到了" + tickets--);
        }
        long endTime=System.currentTimeMillis();
        float excTime=(float)(endTime-startTime)/1000;
        System.out.println(Thread.currentThread().getName()+ "------执行完成！   执行时间："+excTime+"s");
    }
}
