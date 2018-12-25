package com.goat.date;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.YearMonth;
import java.time.temporal.ChronoUnit;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

/**
 * Created by 64274 on 2018/12/25.
 *
 * @ Description: TODO
 * @ author  山羊来了
 * @ date 2018/12/25---16:59
 */
public class WeekUtil {


    /**
     * 取得当前日期是多少周
     * @param date
     * @return
     */
    private int getWeekOfYear(Date date) {
        Calendar c = new GregorianCalendar();
        c.setFirstDayOfWeek(Calendar.MONDAY);
        c.setMinimalDaysInFirstWeek(7);
        c.setTime (date);
        return c.get(Calendar.WEEK_OF_YEAR);
    }

    /**
     * 得到某一年周的总数
     * @param year
     * @return
     */
    public int getMaxWeekNumOfYear(int year) {
        Calendar c = new GregorianCalendar();
        c.set(year, Calendar.DECEMBER, 31, 23, 59, 59);
        return getWeekOfYear(c.getTime());
    }

    /**
     * 得到某年前/后N年某周的第一天
     * @param year(yyyy)
     * @param week
     * @param n  前3年 -3  后5年 +5   当年 0
     * @return
     */
    public static String getLastYearFirstDayOfWeek(String year, String week, Integer n) {
        Calendar cal = getCalendar(year, week, n);
        return getFirstDayOfWeek(cal.getTime());
    }

    /**
     * 得到某年前/后N年某周的 最后一天
     * @param year(yyyy)
     * @param week
     * @param n  前3年 -3  后5年 +5   当年 0
     * @return
     */
    public String getLastYearLastDayOfWeek(String year, String week,Integer n) {
        Calendar cal = getCalendar(year, week, n);
        return getLastDayOfWeek(cal.getTime());
    }

    private static Calendar getCalendar(String year, String week, Integer n) {
        Calendar c = new GregorianCalendar();
        c.set(Calendar.YEAR, Integer.valueOf(year) + n);
        c.set(Calendar.MONTH, Calendar.JANUARY);
        c.set(Calendar.DATE, 1);
        Calendar cal = (GregorianCalendar) c.clone();
        cal.add(Calendar.DATE, (Integer.valueOf(week) - 1) * 7);
        return cal;
    }

    /**
     * 取得指定日期所在周的第一天
     * @param date
     * @return String(yyyyMMdd)
     */
    private static String getFirstDayOfWeek(Date date) {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd");
        Calendar c = new GregorianCalendar();
        c.setFirstDayOfWeek(Calendar.MONDAY);
        c.setTime(date);
        c.set(Calendar.DAY_OF_WEEK, c.getFirstDayOfWeek()); // Monday
        return sdf.format(c.getTime());
    }

    /**
     * 取得指定日期所在周的最后一天
     * @param date
     * @return String(yyyyMMdd)
     */
    private String getLastDayOfWeek(Date date) {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd");
        Calendar c = new GregorianCalendar();
        c.setFirstDayOfWeek(Calendar.MONDAY);
        c.setTime(date);
        c.set(Calendar.DAY_OF_WEEK, c.getFirstDayOfWeek() + 6); // Sunday
        return sdf.format(c.getTime());
    }

    /**
     * 取得当前日期所在周的第一天
     * @return
     */
    public static Date getFirstDayOfWeek() {
        Calendar c = new GregorianCalendar();
        c.setFirstDayOfWeek(Calendar.MONDAY);
        c.setTime(new Date());
        c.set(Calendar.DAY_OF_WEEK, c.getFirstDayOfWeek()); // Monday
        return c.getTime ();
    }

    /**
     * 取得当前日期所在周的最后一天
     * @return
     */
    public Date getLastDayOfWeek() {
        Calendar c = new GregorianCalendar();
        c.setFirstDayOfWeek(Calendar.MONDAY);
        c.setTime(new Date());
        c.set(Calendar.DAY_OF_WEEK, c.getFirstDayOfWeek() + 6); // Sunday
        return c.getTime();
    }

    /**
     * 获取指定月所在的最后一天
     */
    public String getLastDayOfMonth(String year,String month) {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd");
        Calendar cal = Calendar.getInstance();
        cal.set(Calendar.YEAR,Integer.valueOf(year));
        cal.set(Calendar.MONTH, Integer.valueOf(month)-1);
        int lastDay = cal.getActualMaximum(Calendar.DAY_OF_MONTH);
        cal.set(Calendar.DAY_OF_MONTH, lastDay);
        return sdf.format(cal.getTime());
    }

    /**
     * 获取指定月前一个月所在的最后一天
     */
    public String getLastMonthLastDayOfMonth(String year,String month) {
        YearMonth yearMonth = YearMonth.parse(year+"-"+month);
        String s=yearMonth.minus(1, ChronoUnit.MONTHS).toString();
        String[] arr = s.split("-");
        SimpleDateFormat sdf1 = new SimpleDateFormat("yyyyMMdd");
        Calendar cal = Calendar.getInstance();
        cal.set(Calendar.YEAR,Integer.valueOf(arr[0]));
        cal.set(Calendar.MONTH, Integer.valueOf(arr[1])-1);
        int lastDay = cal.getActualMaximum(Calendar.DAY_OF_MONTH);
        cal.set(Calendar.DAY_OF_MONTH, lastDay);
        return sdf1.format(cal.getTime());
    }
    /**
     * 获取指定日期对应去年的这天
     * @param day(yyyyMMdd)
     */
    public String getNowOfLastYear(String day) {
        return (Integer.parseInt(day.substring(0, 4)) - 1) +day.substring(4);
    }

    /**
     * 获得指定日期的前一天
     * @param day(yyyyMMdd)
     * @return
     * @throws Exception
     */
    public String getLastDayOfDay(String day) throws ParseException {
        Calendar c = Calendar.getInstance();
        Date date = new SimpleDateFormat("yyyyMMdd").parse(day);
        c.setTime(date);
        int day1=c.get(Calendar.DATE);
        c.set(Calendar.DATE,day1-1);
        return new SimpleDateFormat("yyyyMMdd").format(c.getTime());
    }

}
