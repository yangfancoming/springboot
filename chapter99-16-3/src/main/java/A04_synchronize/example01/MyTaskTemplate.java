package A04_synchronize.example01;

/**
 * Created by 64274 on 2019/4/18.
 *
 * @ Description: TODO
 * @ author  山羊来了
 * @ date 2019/4/18---13:07
 */
public abstract class MyTaskTemplate {

    public void sleep(){
        try {
            Thread.sleep(100);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public void cacul(long startTime,long endTime){
        float excTime=(float)(endTime-startTime)/1000;
        System.out.println(Thread.currentThread().getName()+ "------执行完成！   执行时间："+excTime+"s");
    }
}
