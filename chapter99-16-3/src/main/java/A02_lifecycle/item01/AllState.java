package A02_lifecycle.item01;

import java.lang.Thread.State;

/**
 * 观察线程的状态
 */
public class AllState {

    private static int count = 1000;

	public static void main(String[] args) {
		Thread t = new Thread(()->{
			for(int i=0;i<5;i++) {
				try {
					Thread.sleep(count);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
				System.out.println(Thread.currentThread().getName()+ "---" + ".....");
			}
		}) ;
		//观察状态
		State state = t.getState();
		System.out.println(Thread.currentThread().getName()+ "---"  + state);  //NEW
		
		t.start(); 
		state = t.getState();   //RUNNABLE
		System.out.println(Thread.currentThread().getName()+ "---"  + state);

		
		while(state != Thread.State.TERMINATED) {
			//活动的线程数
			int num = Thread.activeCount();
			if(num==1) {
				break;
			}
			try {
				Thread.sleep(count);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			state = t.getState();   //TIMED_WAITING
			System.out.println(Thread.currentThread().getName()+ "---"  + state);
		}
	}

}
