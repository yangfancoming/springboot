package debug.item02;


/**
 * Created by Administrator on 2020/1/27.
 *
 * @ Description: TODO
 * @ author  山羊来了
 * @ date 2020/1/27---18:10
 */
public class Consumer implements Runnable {

    private Box box;

    public Consumer(Box box){
        this.box = box;
    }


    @Override
    public void run() {
        while (true){
            box.get();
        }
    }
}
