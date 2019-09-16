package com.goat.date;


import org.junit.Test;

import java.sql.Timestamp;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class DateUtil {


    /** 创建时间戳的三种方式 */
    @Test
    public void timestamp()  {
        Timestamp time1 = new Timestamp(System.currentTimeMillis());
        Timestamp time2 = new Timestamp(new Date().getTime());
        Timestamp time3 = new Timestamp(Calendar.getInstance().getTimeInMillis());
        System.out.println(time1);
        System.out.println(time2);
        System.out.println(time3);
    }

    /**
         * @Description:  常用日期格式
         * @author: Goat
            yyyy-MM-dd
            yyyy-MM-dd HH:mm:ss
            yyyy-MM-dd HH:mm:ss EE
            yyyy-MM-dd HH:mm:ss zzz
         * @Date:   2018/12/12
    */
    @Test
    public void simpleDateFormat ()  {
        SimpleDateFormat aDate=new SimpleDateFormat("yyyy-MM-dd  HH:mm:ss");
        long now=System.currentTimeMillis(); // 当前系统时间
        System.out.println(aDate.format(now)); // 2018-08-12  20:08:52
        SimpleDateFormat myFmt=new SimpleDateFormat("yyyy年MM月dd日 HH时mm分ss秒"); // 2018年12月12日 20时08分52秒
        SimpleDateFormat myFmt1=new SimpleDateFormat("yy/MM/dd HH:mm"); // 18/12/12 20:08
        SimpleDateFormat myFmt2=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");//2018-12-12 20:08:52   等价于now.toLocaleString()
        SimpleDateFormat myFmt3=new SimpleDateFormat("yyyy年MM月dd日 HH时mm分ss秒 E "); // 2018年12月12日 20时08分52秒 星期三
        // 一年中的第 346 天 一年中第50个星期 一月中第3个星期 在一天中20时 CST时区
        SimpleDateFormat myFmt4=new SimpleDateFormat("一年中的第 D 天 一年中第w个星期 一月中第W个星期 在一天中k时 z时区");
        System.out.println(myFmt.format(now));
        System.out.println(myFmt1.format(now));
        System.out.println(myFmt2.format(now));
        System.out.println(myFmt3.format(now));
        System.out.println(myFmt4.format(now));
    }
    @Test
    public void test()  {
        Date date =new Date();
        //%tj表示一年中的第几天
        String strDate =String.format("今天是今年的第%tj天!",date);
        System.out.println(strDate);
    }


    /**
         * @Description: 赵博排班计算函数   白班  夜班  下夜  正休 0,1,2,3  20181209  休
         * @author: Goat
         * @Param:  start  起始日期设定
         * @Param:  end    查询日期
         * @Return:
         * @Date:   2018/12/9
    */
    public static String scheduling(String start,String end) throws ParseException {
        String[] haha = {"正休","白班","夜班","下夜"};
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyyMMdd");
        Date date1 = dateFormat.parse(start);
        Date date2 = dateFormat.parse(end);
        Long result =Math.abs((date1.getTime()-date2.getTime())/(24*3600*1000)) ;
        // 两日期 相差  后与4取余 因为 一共就四种排班
        Integer temp = Math.toIntExact((result % 4));
        // 与4 取余结果 只有 0 1 2 3 四种结果 对应 数组中的四种排班  顺序暂时写死
        return haha[temp];
    }

    @Test
    public void test1() throws ParseException {
        SimpleDateFormat dateFormatter = new SimpleDateFormat("yyyy-MM-dd");
        String str = "2018-12-25";
        Date date = dateFormatter.parse(str);

        dateFormatter.applyPattern("D");
        System.out.println("一年中的第几天：" + dateFormatter.format(date));

        dateFormatter.applyPattern("d");
        System.out.println("一个月中的第几天：" + dateFormatter.format(date));

        dateFormatter.applyPattern("w");
        System.out.println("一年中的第几周：" + dateFormatter.format(date));

        dateFormatter.applyPattern("W");
        System.out.println("一个月中的第几周：" + dateFormatter.format(date));

        dateFormatter.applyPattern("E");
        System.out.println("一个星期中的天数：" + dateFormatter.format(date));
    }


    /**  常用 时间格式  日期格式 日期转换 转换  转化  */

    /**  Date -> Timestamp  */
    @Test
    public void test2()  {

        Date date = new Date();
        Timestamp ts = new Timestamp(date.getTime());
        System.out.println(ts);
    }
    /**  Timestamp -> Date  */
    @Test
    public void test3() {
        Timestamp ts = new Timestamp(System.currentTimeMillis());
        Date date = ts;
        System.out.println(date);
    }

    /**  Timestamp -> String  */
    @Test
    public void test4() {
        Timestamp ts = new Timestamp(System.currentTimeMillis());
        String tsStr;
        DateFormat sdf = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
        //方法一
        tsStr = sdf.format(ts);
        System.out.println(tsStr);
        //方法二
        tsStr = ts.toString();
        System.out.println(tsStr);
    }

    /**   String ->Timestamp */
    @Test
    public void test5() {
        String tsStr = "2011-05-09 11:49:45";
        Timestamp ts = Timestamp.valueOf(tsStr);
        System.out.println(ts);
    }

    /**   Date -> String */
    @Test
    public void test6() {
        Date date = new Date();
        System.out.println(date.toString());
        //format的格式可以任意
        DateFormat sdf = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
        DateFormat sdf2 = new SimpleDateFormat("yyyy-MM-dd HH/mm/ss");
        String dateStr1 = sdf.format(date);
        System.out.println(dateStr1);
        String dateStr2 = sdf2.format(date);
        System.out.println(dateStr2);
    }

    /**   String -> Date */
    @Test
    public void test7() throws ParseException {
        String dateStr = "2010/05/04 12:34:23";
        //注意format的格式要与日期String的格式相匹配
        DateFormat sdf = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
        Date date = sdf.parse(dateStr);
        System.out.println(date.toString());
    }


    /**
     *通过年周日获取日期
     * 通过周数获取日期
     * @param year
     * @param weeks
     * @param day (Calendar SUNDAY = 1;MONDAY = 2; 以此类推 看具体需求判断day参数是否需要+1)
     * @return
     */
    public Date getDateByWeek(Integer year,Integer weeks,Integer day){

        Calendar cal = Calendar.getInstance();
        cal.set(Calendar.YEAR,year);
        cal.set(Calendar.WEEK_OF_YEAR,weeks);
        cal.set(Calendar.DAY_OF_WEEK,day);
        return cal.getTime();
    }

    @Test
    public void test8(){

        SimpleDateFormat aDate = new SimpleDateFormat("yyyy-MM-dd  HH:mm:ss");
        Date date = getDateByWeek(2019, 5, 2);
        System.out.println(aDate.format(date));
    }
}
