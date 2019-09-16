package A04;

import org.junit.Test;

import java.text.SimpleDateFormat;
import java.util.Calendar;

import static java.util.Calendar.*;

/**
 * Description:
 * 1.全世界通用的日历 ：Gregorian Calendar 公历年-格里高利日历子类-GregorianCalendar
 * 2.Calendar是一个抽象类，不能创建实例。
 */
public class MyCalendar {

    Calendar c = Calendar.getInstance();

	public static void main(String[] args) {


		Calendar cal2 = Calendar.getInstance();
		cal2.set(2003, 7, 31, 0, 0 , 0); // 2003-8-31
		// 因为进位到后月份改为2月，2月没有31日，自动变成29日
		cal2.add(MONTH, 6); // 2003-8-31 => 2004-2-29
		System.out.println(cal2.getTime());


		Calendar cal3 = Calendar.getInstance();
		cal3.set(2003, 7, 23, 0, 0 , 0); //2003-8-23
		// MONTH字段“进位”，但YEAR字段并不增加
		cal3.roll(MONTH, 6); //2003-8-23 => 2003-2-23
		System.out.println(cal3.getTime());


		Calendar cal4 = Calendar.getInstance();
		cal4.set(2003, 7, 31, 0, 0 , 0); //2003-8-31
		// MONTH字段“进位”后变成2，2月没有31日，
		// YEAR字段不会改变，2003年2月只有28天
		cal4.roll(MONTH, 6); //2003-8-31 => 2003-2-28
		System.out.println(cal4.getTime());
	}

	/**
     * 获取当前年
     * 获取当前月
     * 获取当前日
	*/
	@Test
    public void test(){
        System.out.println(c.get(YEAR)); // 取出年
        System.out.println(c.get(MONTH)+1);// 取出月份
        System.out.println(c.get(DATE)); // 取出日
    }

    @Test
    public void test1(){
        c.set(2003 , 10 , 23 , 19, 32, 23); //2003-11-23 12:32:23
        String format1 = new SimpleDateFormat("yyyy-MM-dd  HH:mm:ss").format(c.getTime());
        String format2 = new SimpleDateFormat("yyyy-MM-dd  HH:mm:ss").format(c.getTime());
        System.out.println("分别设置年、月、日、小时、分钟、秒 \t" + format1);
        System.out.println("分别设置年、月、日、小时、分钟、秒 \t" + format2);
    }

    @Test
    public void year(){
        c.add(YEAR , 1);
        String format3 = new SimpleDateFormat("yyyy-MM-dd  HH:mm:ss").format(c.getTime());
        System.out.println("将Calendar的年后推1年 \t" + format3);


        c.add(YEAR , -1); //2002-11-23 12:32:23
        String format4 = new SimpleDateFormat("yyyy-MM-dd  HH:mm:ss").format(c.getTime());
        System.out.println("将Calendar的年前推1年 \t" + format4);

    }

    /**
     *
     DAY_OF_MONTH  一个月中的第几天
     DAY_OF_WEEK   一周中的第几天
    */
    @Test
    public void month(){
        c.add(MONTH , 1);
        String format5 = new SimpleDateFormat("yyyy-MM-dd  HH:mm:ss").format(c.getTime());
        System.out.println("增加一个月 \t"+ format5);

        c.add(MONTH , -8);
        String format4 = new SimpleDateFormat("yyyy-MM-dd  HH:mm:ss").format(c.getTime());
        System.out.println("减少8个月 \t"+ format4);
    }

    @Test
    public void week(){
        c.add(WEEK_OF_YEAR , 1);
        String format4 = new SimpleDateFormat("yyyy-MM-dd  HH:mm:ss").format(c.getTime());
        System.out.println("增加一个礼拜 \t"+ format4);

        c.add(WEEK_OF_YEAR , 1);
        String format5 = new SimpleDateFormat("yyyy-MM-dd  HH:mm:ss").format(c.getTime());
        System.out.println("增加一个礼拜 \t"+ format5);
    }

    @Test
    public void day(){
        c.add(DAY_OF_YEAR , 1);
        String format4 = new SimpleDateFormat("yyyy-MM-dd  HH:mm:ss").format(c.getTime());
        System.out.println("增加一天 \t"+ format4);

        c.add(DATE , 1);
        String format5 = new SimpleDateFormat("yyyy-MM-dd  HH:mm:ss").format(c.getTime());
        System.out.println("增加一天 \t"+ format5);

        c.add(DAY_OF_MONTH , 1);
        String format6 = new SimpleDateFormat("yyyy-MM-dd  HH:mm:ss").format(c.getTime());
        System.out.println("增加一天 \t"+ format6);

        c.add(DAY_OF_WEEK , 1);
        String format7 = new SimpleDateFormat("yyyy-MM-dd  HH:mm:ss").format(c.getTime());
        System.out.println("增加一天 \t"+ format7);
    }

    @Test
    public void test3(){
        c.set(2003, 7, 23, 0, 0 , 0);
        System.out.println(new SimpleDateFormat("yyyy-MM-dd  HH:mm:ss").format(c.getTime())); // 2003-08-23  00:00:00
        c.add(MONTH, 6);  // 增加6个月
        System.out.println(new SimpleDateFormat("yyyy-MM-dd  HH:mm:ss").format(c.getTime())); // 2004-02-23  00:00:00
    }

    @Test
    public void test4(){ // 获取当前时间
        Calendar c = Calendar.getInstance();
        System.out.println(new SimpleDateFormat("yyyy-MM-dd  HH:mm:ss").format(c.getTime())); // 2004-02-23  00:00:00
    }

    @Test
    public void test11(){
        String temp1 = "1544".substring(0, 2);
        System.out.println(temp1);
    }


}

