package A02_lifecycle;
/**
 * yield 礼让线程，暂停线程 直接进入就绪状态不是阻塞状态
 *
 * 运行结果可以看出 主线程再运行到 39、59、69....的时候会概率性出现礼让 子线程
 */
public class YieldDemo02 {

	public static void main(String[] args) {
		new Thread(()->{
			for(int i=0;i<100;i++) {
					System.out.println("lambda...."+i);
			}
		}) .start();
		
		for(int i=0;i<100;i++) {
			if(i%10==0) {
				Thread.yield(); //main礼让
			}
			System.out.println("main...."+i);
		}
	}

}


