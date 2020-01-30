package summary;
/**
 * 其他方法
 * isAlive:线程是否还活着
 * Thread.currentThread():当前线程
 * setName、getName:代理名称
 */
public class InfoTest {

	public static void main(String[] args) throws InterruptedException {
		System.out.println(Thread.currentThread().isAlive());
		
		//给子线程 设置名称 ：真实角色+代理角色
		MyInfo info = new MyInfo("战斗机");
		Thread t = new Thread(info);
		t.setName("公鸡");
		t.start();
		Thread.sleep(500);
		System.out.println("MyInfo 子线程的存活状态：" + t.isAlive());
	}

}

class MyInfo implements Runnable{
	private String name;
	
	public MyInfo(String name) {
		this.name = name;
	}

	@Override
	public void run() {
		System.out.println(Thread.currentThread().getName()+"-->"+name);
	}
	
}
