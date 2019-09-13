import org.junit.Test;

public class TestNG3 {


    /**
     sos 在多线程测试中  必须要是使用  psvm或是testng 进行测试    使用 @Test 会出现多线程运行不正常问题！

     涉及到 守护线程和非守护线程的知识：
     一般我们创建的多线程都是非守护线程.
     但是也有例外,例如在junit环境中 创建的多线程都变成了守护线程模式.
     所以测试时,就会搞不清状况: 为什么用了多线程,结果跑不出来,
     其实都是因为守护子线程没有运行结束, 测试进程就已经运行结束了.

     junit case 的特点 ：
     1.@test 函数是不会等待子线程运行结束的,只要@test函数执行结束就立即结束.
     2.所有junit 中的@test函数 是依次执行的.

     main() 的多线程是非守护线程
     在 main 中创建的多线程是非守护线程模式,所以只要子线程未执行结束, main线程会处于等待状态 ,这是程序进程也不会结束.
    */
    @Test
    public void test(){

        Thread t1 = new Thread(()->{
            for (int i = 0; i <100 ; i++) {
                System.out.println(Thread.currentThread().getName()+"-----------"+i);
            }
        });

        Thread t2 = new Thread(()->{
            for (int i = 0; i <100 ; i++) {
                System.out.println(Thread.currentThread().getName()+"-----------"+i);
            }
        });
        t1.start();
        t2.start();
        System.out.println(t2.isDaemon());
        System.out.println(t1.isDaemon());
    }
}
