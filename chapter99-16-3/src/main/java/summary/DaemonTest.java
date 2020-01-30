package summary;
/**
 * 守护线程：是为用户线程服务的；jvm停止不用等待守护线程执行完毕
 * 默认:用户线程 jvm等待用户线程执行完毕才会停止，不会等待守护线程
 *
 */
public class DaemonTest {

	public static void main(String[] args) {

        God god = new God();
		Thread t =new Thread(god);		
		t.setDaemon(true);//将用户线程调整为守护后jvm不会等待该线程执行结束。  注释掉该行 God 会进入死循环
		t.start();

        You you  = new You();
		new Thread(you).start();
	}

}

class You implements Runnable{
	@Override
	public void run() {
		for(int i=1;i<=10;i++) {
			System.out.println("happy life..." + i);
		}
		System.out.println("dead.....");
	}
}

class God implements Runnable{
	@Override
	public void run() {
		for(;true;) {
			System.out.println("bless you...");
		}
	}
}