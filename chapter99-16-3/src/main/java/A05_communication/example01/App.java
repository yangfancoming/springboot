package A05_communication.example01;

import model.Person;

/**
 * Created by 64274 on 2019/4/29.
 *
 * @ Description: 未使用线程通信技术 无法完成 如花和凤姐 交替输出
 * @ author  山羊来了
 * @ date 2019/4/29---13:51
 */
public class App {

    public static void main(String[] args) {
        //创建资源对象
        Person person = new Person();
        //创建两个线程       传入Runnable的实现类  并且把资源对象传入构造方法
        Thread t1 = new Thread(new ProductThread(person));
        Thread t2 = new Thread(new ConsumerThread(person));
        t1.start();
        t2.start();
    }




}
