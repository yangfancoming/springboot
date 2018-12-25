package com.goat.date;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
     * @Description:  排班
     * @author: 杨帆
     * @Param:
     * @Return:
     * @Date:   2018/9/27
*/
public class DateUtilTest {


    @BeforeMethod
    public void beforeMethod(){

    }


    @Test
    public void test() throws ParseException {
        System.out.println(DateUtil.scheduling("20181209","20181213"));
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
    @Test
    public void tes1t()   {
//        String temp = WeekUtil.getFirstDayOfWeek("2018","30");
        String temp = WeekUtil.getLastYearFirstDayOfWeek("2018","30",0);
        System.out.println(temp);

    }

}
