package unsafe;

import java.util.ArrayList;
import java.util.List;

/**
 * 线程不安全：操作容器
 * 操作结果 list.size() 小于 1000
 */
public class UnsafeTest03 {

	public static void main(String[] args) throws InterruptedException {
		List<String> list = new ArrayList<>();
		for(int i=1;i<=1000;i++) {
//		    synchronized (list){  // 同步代码块 锁list 一般情况下是 修改谁就锁谁
                System.out.println(i);
                new Thread(()->list.add(Thread.currentThread().getName())) .start();
//            }
		}
        Thread.sleep(1000);
        System.out.println(list.size());
	}

}

