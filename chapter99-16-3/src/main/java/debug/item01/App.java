package debug.item01;


/**
 * Created by Administrator on 2020/1/27.
 *
 * @ Description: TODO
 * @ author  山羊来了
 * @ date 2020/1/27---18:01
 */
public class App {

    public static void main(String[] args) {
        Thread thread1 = new Thread(new MyRunable(),"曹操");
        Thread thread2 = new Thread(new MyRunable(),"刘备");
        Thread thread3 = new Thread(new MyRunable(),"孙权");

        thread1.start();
        thread2.start();
        thread3.start();
    }


}
