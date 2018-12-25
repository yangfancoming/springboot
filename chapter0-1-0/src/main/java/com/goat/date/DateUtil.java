package com.goat.date;

import org.testng.annotations.Test;

import java.sql.Timestamp;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class DateUtil {


    // 创建时间戳的三种方式
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
         * @author: 杨帆
            yyyy-MM-dd
            yyyy-MM-dd HH:mm:ss
            yyyy-MM-dd HH:mm:ss EE
            yyyy-MM-dd HH:mm:ss zzz
         * @Date:   2018/12/12
    */
    @Test
    public void simpleDateFormat ()  {
        SimpleDateFormat aDate=new SimpleDateFormat("yyyy-mm-dd  HH:mm:ss");
        long now=System.currentTimeMillis();
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
         * @author: 杨帆
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
}
