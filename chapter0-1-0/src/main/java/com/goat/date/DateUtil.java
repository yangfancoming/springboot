package com.goat.date;

import org.testng.annotations.Test;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class DateUtil {




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


}
