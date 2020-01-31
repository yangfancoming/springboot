package unsafe;
/**
 * 线程不安全: 数据有负数、相同
 * 出现负数的原因：循环10次  3个线程 最后一次循环 全部都进入到test() 方法 都去获取ticketNums 导致的，
 *      因为即使更改flag也没有意义了 因为是最后一次循环了不会在判断flag了
 *
 * 线程111--> 进入test  ticketNums =2
 * 线程111--> 跳过if ticketNums =2
 * 线程222拿到票：-->2
 * 线程222--> 进入test  ticketNums =1
 * 线程222--> 跳过if ticketNums =1
 * 线程333拿到票：-->1                        线程333拿到最后一张票的时候 线程111和线程222已经进入了test()方法，并且跳过了if判断，所以线程111和222肯定一个拿0 一个拿-1 ！！！
 * 线程333--> 进入test  ticketNums =0
 * 线程333--> if 返回 ticketNums =0
 * 线程222拿到票：-->0
 * 线程111拿到票：-->-1
 *
 * 出现相同的原因：每个线程都是通过自己的本地内存与主内存进行交互，每个线程都是从主存拷贝对象到本地内存进行操作后，再去更新主存
 *      由于第一个线程拷贝10到自己的本地内存 更改后还没来得及去更新主存，第二个线程就去拷贝10到自己的本地内存，所导致的。
 */
public class UnsafeTest01 {

	public static void main(String[] args) {
		//一份资源
		UnsafeWeb12306 web = new UnsafeWeb12306();
		//多个代理
		new Thread(web,"线程111").start();
		new Thread(web,"线程222").start();
		new Thread(web,"线程333").start();
	}

}

class UnsafeWeb12306 implements Runnable{
	//票数
	private int ticketNums = 10;
	private boolean flag = true;

	@Override
	public void run() {
		while(flag) {
			test();
		}
	}

	public void test() {
        System.out.println(Thread.currentThread().getName()+"--> 进入test  ticketNums =" + ticketNums);
		if(ticketNums<=0) {
            System.out.println(Thread.currentThread().getName()+"--> if 返回 ticketNums =" + ticketNums);
			flag = false;
			return ;
		}
        System.out.println(Thread.currentThread().getName()+"--> 跳过if ticketNums =" + ticketNums);
		//模拟延时
		try {
			Thread.sleep(200);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		System.out.println(Thread.currentThread().getName()+"拿到票：-->"+ticketNums--);
	}
}