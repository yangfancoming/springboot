package A07_pool.example00;

/**
 * Created by 64274 on 2019/4/30.
 *
 * @ Description: TODO
 * @ author  山羊来了
 * @ date 2019/4/30---10:43
 */
public class TempThread implements Runnable {

    private int id = 0;

    @Override
    public void run() {
        id++;
    }
}
