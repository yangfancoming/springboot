package A05_communication.example01;

import model.Person;

/**
 * Created by 64274 on 2019/4/29.
 *
 * @ Description: TODO
 * @ author  山羊来了
 * @ date 2019/4/29---13:50
 */
//创建消费对象Runnable的实现类   作用用来消费person里面的数据  就是把person里面的name和打印到控制台
public class ConsumerThread implements Runnable {
    //创建资源对象
    Person person;
    //有参构造  因为消费者和生产者要使用一个资源对象，所以创建构造方法传入资源对象
    public ConsumerThread(Person p) {
        person = p;
    }
    @Override
    public void run() {
        //死循环消费数据
        while (true) {
            //因为两个线程使用的是同一个资源对象 所以可以使用这个资源对象作为锁对象
            synchronized (person) {
                //判断生产者是否已经生产了数据，如果生产了数据就打印
                if (person.name != null && person.age != 0) {
                    System.out.println(person.name + " " + person.age);
                }
            }
        }
    }
}
