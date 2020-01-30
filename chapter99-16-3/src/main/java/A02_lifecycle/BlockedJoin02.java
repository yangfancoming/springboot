package A02_lifecycle;
/**
 * join:合并线程，插队线程
 *
 */
public class BlockedJoin02 {

	public static void main(String[] args) {
		System.out.println("爸爸和儿子买烟的故事");
		new Thread(new Father()).start();
	}

}

class Father implements Runnable{
    @Override
	public void run() {
		System.out.println("想抽烟，发现没了，让儿子去买中华");
		Thread t = new Thread(new Son());
		t.start();
		try {
			t.join(); //father被阻塞
			System.out.println("老爸接过烟，把零钱给了儿子");
		} catch (InterruptedException e) {e.printStackTrace();}
	}
}

class Son implements Runnable{

    @Override
	public void run() {
		System.out.println("接过老爸的钱出去了。。。路边有个游戏厅，玩了起来。。。 ");
		for(int i=0;i<5;i++) {
			System.out.println(i+"秒过去了...");
			try {Thread.sleep(1000);} catch (InterruptedException e) {e.printStackTrace();}
		}
		System.out.println("赶紧买烟去。。。。手拿一包中华回家了。。。。");
	}
}
