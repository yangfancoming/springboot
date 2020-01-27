package debug.item02;

/**
 * Created by Administrator on 2020/1/27.
 *
 * @ Description: TODO
 * @ author  山羊来了
 * @ date 2020/1/27---18:12
 */
public class Producer implements Runnable {

    private Box box;

    public Producer(Box box){
        this.box = box;
    }

    @Override
    public void run() {
        for (int i = 1; i <= 5; i++) {
            box.put(i);
        }
    }
}
