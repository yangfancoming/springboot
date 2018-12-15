import org.testng.annotations.Test;

public class TestNG3 {

    // sos 在多线程测试中  必须要是使用  psvm或是testng 进行测试    使用 @Test 会出现多线程运行不正常问题！
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
    }
}
