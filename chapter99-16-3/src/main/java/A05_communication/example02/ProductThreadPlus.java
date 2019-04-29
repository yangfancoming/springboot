package A05_communication.example02;

import model.Person;

/**
 * Created by 64274 on 2019/4/29.
 *
 * @ Description: TODO
 * @ author  山羊来了
 * @ date 2019/4/29---13:49
 */
//创建生产者对象Runnable的实现类  生产数据就是给person的name和age赋值
public class ProductThreadPlus implements Runnable {
    //创建资源对象
    Person person;
    //有参构造  因为消费者和生产者要使用一个资源对象，所以创建构造方法传入资源对象
    public ProductThreadPlus(Person p) {
        person = p;
    }
    @Override
    public void run() {
        //创建一个变量，使每一次生产的数据都不一样
        boolean b = true;
        while (true) {

            synchronized (person) {  //因为两个线程使用的是同一个资源对象 所以可以使用这个资源对象作为锁对象
                //使用判断生产不同数据
                if (b){
                    person.name = "如花";
                    person.age = 18;
                    b = false;
                } else {
                    person.name = "凤姐";
                    person.age = 100;
                    b = true;
                }
                try {
                    //唤醒全部线程
                    person.notifyAll();
                    //调用该方法线程进入无限等待状态 ，并且释放锁对象  等待其他线程唤醒
                    person.wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
