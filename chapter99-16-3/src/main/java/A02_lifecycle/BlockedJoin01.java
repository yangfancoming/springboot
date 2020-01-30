package A02_lifecycle;
/**
 * join:合并线程，插队线程
 *
 * 运行结果可以看到：
 * 再主线程打印40之前 都是主线程和子线程 交互运行，但是当主线程打印到40时
 * 主线程被插队，必须等到其他线程都运行完后 主线程才能再开始运行
 *
 */
public class BlockedJoin01 {

    public static void main(String[] args) throws InterruptedException {
        Thread t=new Thread(()->{
            for(int i=0;i<50;i++) {
                System.out.println("lambda...."+i);
            }
        });
        t.start();

        for(int i=0;i<50;i++) {
            if(i==40) {
                t.join(); //插队 main被阻塞了
            }
            System.out.println("main...."+i);
        }
    }

}
