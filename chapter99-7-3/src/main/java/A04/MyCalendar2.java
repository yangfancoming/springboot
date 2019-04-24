package A04;

import org.junit.Test;
import java.text.SimpleDateFormat;
import java.util.Calendar;


/**
 Calendar中add函数和roll函数的用法及区别
 */
public class MyCalendar2 {

    Calendar c = Calendar.getInstance();


    /** 取某个时间点后的整点时刻。例如1984年7月7日15:23:05后的整点时刻即为1984-07-07 16:00:00 */
	@Test
    public void test(){
        c.add(Calendar.HOUR_OF_DAY, 1);//小时上加1
        c.set(Calendar.MINUTE, 0);//分钟设为0
        c.set(Calendar.SECOND, 0);//秒钟设为0
        System.out.println(new SimpleDateFormat("yyyy-MM-dd  HH:mm:ss").format(c.getTime())); // 2003-08-23  00:00:00
    }

    /** 取某个日历之前的某个月。例如要取2002年1月12号之前1个月的时间，应该是2001年12月12日 */
    @Test
    public void test1(){
        c.set(2002, 0, 12);//代表2002年1月12日
        c.add(Calendar.MONTH, -1);//这样就将日期设置成了2001年12月12日。
        System.out.println(new SimpleDateFormat("yyyy-MM-dd  HH:mm:ss").format(c.getTime())); // 2001-12-12  20:18:30
    }

    /** 但是这种情况如果用roll()来实现 */
    @Test
    public void year(){
        c.set(2002, 0, 12);
        c.roll(Calendar.MONTH, -1);
        System.out.println(new SimpleDateFormat("yyyy-MM-dd  HH:mm:ss").format(c.getTime())); // 2002-12-12  20:19:43
    }


    /**
     结论：roll()函数处理，只会比相应的字段进行处理，不会智能的对其它字段也进行逻辑上的改变。但是add()函数会在逻辑上改变其它字段，使结果正确。
     注：Calendar中的Month是从0-11的，0代表1月，11代表12月。
     */

}

