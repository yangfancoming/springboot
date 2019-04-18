package A04_synchronize.example01;

/**
 * Created by 64274 on 2019/4/18.
 *
 * @ Description: TODO
 * @ author  山羊来了
 * @ date 2019/4/18---13:07
 */
public abstract class MyTaskTemplate {

    public int test(int tickets){
        try {
            Thread.sleep(100);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return tickets;
    }
}
