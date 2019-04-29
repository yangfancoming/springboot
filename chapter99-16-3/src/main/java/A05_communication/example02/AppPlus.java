package A05_communication.example02;

import model.Person;

/**
 * Created by 64274 on 2019/4/29.
 *
 * @ Description: 使用线程通信技术完成两行交替输出
 * @ author  山羊来了
 * @ date 2019/4/29---13:51
 */
public class AppPlus {

    public static void main(String[] args) {
        //创建资源对象
        Person person = new Person();
        //创建两哥线程       传入Runnable的实现类  并且把资源对象传入构造方法
        Thread thread1 = new Thread(new ConsumerThreadPlus(person));
        Thread thread2 = new Thread(new ProductThreadPlus(person));
        //开启线程
        thread1.start();
        thread2.start();
    }




}
