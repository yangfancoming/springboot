package lambda;
/**
 * Lambda表达式 简化的历程演示  (用一次)的使用
 */
public class LambdaThread {

	//1.静态内部类
	static class Test implements Runnable{		
		public void run() {
			for(int i=0;i<10;i++) {
				System.out.println("静态内部类11");
			}
		}
	}

	public static void main(String[] args) {			
		new Thread(new Test()).start();
		
		//2.局部内部类  由于只使用一次 所以推荐使用 匿名内部类
		class Test2 implements Runnable{
			public void run() {
				for(int i=0;i<10;i++) {
					System.out.println("局部内部类222");
				}
			}
		}
		new Thread(new Test2()).start();


		//3.匿名内部类 必须借助接口或者父类  由于只需要关注方法体内容 所以推荐使用 lambda表达式
		new Thread(new Runnable() {
			public void run() {
				for(int i=0;i<10;i++) {
					System.out.println("匿名内部类333");
				}
			}
		}).start();


		//jdk8 简化  lambda表达式
		new Thread(()-> {
				for(int i=0;i<20;i++) {
					System.out.println("lambda表达式4444");
				}
			}
		).start();
		
	}

}
