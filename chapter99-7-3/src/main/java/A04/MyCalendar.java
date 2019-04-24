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
		Calendar cal1 = Calendar.getInstance();
		cal1.set(2003, 7, 23, 0, 0 , 0); // 2003-8-23
		cal1.add(MONTH, 6); //2003-8-23 => 2004-2-23
		System.out.println(cal1.getTime());


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

	@Test
    public void test(){
        System.out.println(c.get(YEAR)); // 取出年
        System.out.println(c.get(MONTH)+1);// 取出月份
        System.out.println(c.get(DATE)); // 取出日
    }

    @Test
    public void test1(){
        c.set(2003 , 10 , 23 , 19, 32, 23); //2003-11-23 12:32:23
//        String format1 = new SimpleDateFormat("yyyy-MM-dd  HH:mm:ss").format(c.getTime());
        String format1 = new SimpleDateFormat("YYYY-mm-dd  hh:MM:ss").format(c.getTime());
        System.out.println("分别设置年、月、日、小时、分钟、秒 \t" + format1);


        c.add(YEAR , -1); //2002-11-23 12:32:23
        String format2 = new SimpleDateFormat("yyyy-MM-dd  HH:mm:ss").format(c.getTime());
        System.out.println("将Calendar的年前推1年 \t" + format2);

        c.roll(MONTH , -8); //2002-03-23 12:32:23
        String format3 = new SimpleDateFormat("yyyy-MM-dd  HH:mm:ss").format(c.getTime());
        System.out.println("将Calendar的月前推8个月 \t"+ format3);
    }
}

