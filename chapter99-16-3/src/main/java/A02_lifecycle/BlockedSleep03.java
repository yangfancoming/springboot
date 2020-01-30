package A02_lifecycle;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * sleep模拟倒计时
 */
public class BlockedSleep03 {

	public static void main(String[] args) throws InterruptedException {
        test1();
        test2();
	}
	
	public static void test1() throws InterruptedException {
		//倒数10个数，1秒一个
		int num = 10;
		while(true) {
			Thread.sleep(1000);
			System.out.println(num--);
		}
	}

    public static void test2() throws InterruptedException {
        //倒计时  现在的时候+10秒
        Date endTime = new Date(System.currentTimeMillis()+1000*10);
        long end = endTime.getTime();
        while(true) {
            // 每隔1秒打印下时间
            System.out.println(new SimpleDateFormat("mm:ss").format(endTime));
            Thread.sleep(1000);
            endTime=new Date(endTime.getTime()-1000);
            if(end-10000 >endTime.getTime() ) {
                break;
            }
        }

    }
}