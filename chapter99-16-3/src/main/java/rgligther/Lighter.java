package rgligther;

/**
 * Created by 64274 on 2019/4/22.
 *
 * @ Description: 灯线程
 * @ author  山羊来了
 * @ date 2019/4/22---10:17
 */
public class Lighter extends Thread{
    //代表灯当前的状态（这里只考虑红绿两种状态）
    public String state;

    @Override
    public void run(){
        while (true){
            try {
                //初始状态设为红灯，且红灯时常为10s
                state = "red";
                System.out.println("lighter:现在是红灯，静止车辆通行");
                Thread.sleep(10*1000);
                //10s后灯变绿，设绿灯时间位5秒
                state = "green";
                System.out.println("lighter:现在变绿灯了，车辆可以通行了。");
                Lighter.sleep(5*1000);
            } catch (InterruptedException e) {
                System.out.println("出错了:"+e);
            }
        }
    }
}