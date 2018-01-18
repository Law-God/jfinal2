package com.common.util;

import com.jfinal.kit.StrKit;
import org.apache.log4j.Logger;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

/**
 * @Author 张志凯 https://github.com/Law-God/phantom-util
 * phantom-util
 * com.phantom.util.date.DateUtil
 * 2016-07-28 19:15
 * 日期工具类
 */
public final class DateUtil {
    private final Logger log = Logger.getLogger(DateUtil.class);
    public static final String DEFAULT_DATE_REGEX = "yyyy-MM-dd";
    public static final String DEFAULT_DATE_TIME_REGEX = "yyyy-MM-dd HH:mm:ss";
    public static final String DEFAULT_TIME_REGEX = "HH:mm:ss";
    public static final DateFormat DEFAULT_DATE_FORMAT = new SimpleDateFormat(DEFAULT_DATE_REGEX);
    public static final DateFormat DEFAULT_DATE_TIME_FORMAT = new SimpleDateFormat(DEFAULT_DATE_TIME_REGEX);
    public static final DateFormat DEFAULT_TIME_FORMAT = new SimpleDateFormat(DEFAULT_TIME_REGEX);
    public static List<String> regexs = new ArrayList<String>(){{
        add(DEFAULT_DATE_REGEX);
        add(DEFAULT_DATE_TIME_REGEX);
        add(DEFAULT_TIME_REGEX);
    }};

    public static Map<String,DateFormat> REGEX_FORMAT = new HashMap<String,DateFormat>(){{
        put(DEFAULT_DATE_REGEX,DEFAULT_DATE_FORMAT);
        put(DEFAULT_DATE_TIME_REGEX,DEFAULT_DATE_TIME_FORMAT);
        put(DEFAULT_TIME_REGEX,DEFAULT_TIME_FORMAT);
    }};


    /**
     * 系统当前日期部分，格式 yyyy-MM-dd
     * @return String 格式 yyyy-MM-dd
     */
    public static String nowDate(){
        Date d = new Date();
        return DEFAULT_DATE_FORMAT.format(d);
    }

    /**
     * 系统当前时间部分，格式 HH:mm:ss
     * @return String 格式 HH:mm:ss
     */
    public static String nowTime(){
        Date d = new Date();
        return DEFAULT_TIME_FORMAT.format(d);
    }

    /**
     * 系统当前日期时间，格式 yyyy-MM-dd HH:mm:ss
     * @return String 格式 yyyy-MM-dd HH:mm:ss
     */
    public static String nowDateTime(){
        Date d = new Date();
        return DEFAULT_DATE_TIME_FORMAT.format(d);
    }

    /**
     * 日期类型转字符串类型
     * @param date
     * @return String 格式 yyyy-MM-dd
     */
    public static String date2Str(Date date){
        if(date == null)
            return null;
        return DEFAULT_DATE_FORMAT.format(date);
    }

    /**
     * 根据指定日期格式将日期类型转换字符串类型
     * @param date
     * @param pattern
     * @return String
     */
    public static String date2Str(Date date,String pattern){
        if(date == null || StrKit.isBlank(pattern))
            return null;
        if(!regexs.contains(pattern)){
            throw new RuntimeException("日期格式不在"+regexs.toString());
        }
        DateFormat format = new SimpleDateFormat(pattern);
        return format.format(date);
    }

    /**
     * 字符串日期类型转日期类型
     * @param date 日期字符串
     * @return 日期类型
     */
    public static Date parseDate(String date){
        if(StrKit.isBlank(date))
            return null;

        Date d = null;
        try {
            d = DEFAULT_DATE_FORMAT.parse(date);
        } catch (ParseException e) {
            throw new RuntimeException(e);
        }
        return d;
    }

    /**
     * 字符串日期类型转成指定日期格式日期类型
     * @param date 日期字符串
     * @param pattern 转换后日期格式
     * @return
     */
    public static Date parseDate(String date,String pattern){
        if(StrKit.isBlank(date) || StrKit.isBlank(pattern))
            return null;

        if(!regexs.contains(pattern)){
            throw new RuntimeException("日期格式不在"+regexs.toString());
        }

        Date d = null;
        for(Map.Entry<String,DateFormat> m : REGEX_FORMAT.entrySet()){
            String regex = m.getKey();
            if(regex.equals(pattern)){
                DateFormat format = m.getValue();
                try {
                    d = format.parse(date);
                } catch (ParseException e) {
                    throw new RuntimeException(e);
                }
            }
        }
        return d;
    }

    /**
     * 日期年份加减
     * @param date 日期
     * @param year 年
     * @return
     */
    public static Date addYear(Date date,int year){
        return addDate(date,year,0,0);
    }

    /**
     * 日期月份加减
     * @param date 日期
     * @param month 月
     * @return
     */
    public static Date addMonth(Date date,int month){
        return addDate(date,0,month,0);
    }

    /**
     * 日期天数加减
     * @param date 日期
     * @param day 天数
     * @return
     */
    public static Date addDay(Date date,int day){
        return addDate(date,0,0,day);
    }

    /**
     * 日期加减操作
     * @param date 日期
     * @param year 年
     * @param month 月
     * @param day 日
     * @return 日期
     */
    public static Date addDate(Date date,int year,int month,int day){
        if(date == null)
            return null;
        Calendar c = Calendar.getInstance();
        c.setTime(date);
        if(year != 0){
            int y = c.get(Calendar.YEAR);
            c.set(Calendar.YEAR,year+y);
        }
        if(month != 0){
            int m = c.get(Calendar.MONTH);
            c.set(Calendar.MONTH,m+month);
        }
        if(day != 0){
            int d = c.get(Calendar.DAY_OF_MONTH);
            c.set(Calendar.DAY_OF_MONTH,d+day);
        }
        return c.getTime();
    }

    /**
     * 日期类型转换为List组成
     * @param date 日期
     * @return
     */
    public static List<Integer> getDateCompose(Date date){
        List<Integer> list = new ArrayList<Integer>();
        if(date == null)
            throw new RuntimeException(DateUtil.class.getName() + " getDateCompose(Date date)，参数不能为空");
        Calendar c = Calendar.getInstance();
        c.setTime(date);
        list.add(c.get(Calendar.YEAR));
        list.add(c.get(Calendar.MONTH));
        list.add(c.get(Calendar.DAY_OF_MONTH));
        list.add(c.get(Calendar.HOUR));
        list.add(c.get(Calendar.MINUTE));
        list.add(c.get(Calendar.SECOND));
        return list;
    }

    /**
     * 日期年份获取
     * @param date 日期 格式yyyy
     * @return 年yyyy
     */
    public static int getDateYear(Date date){
        List<Integer> list = getDateCompose(date);
        return  list.get(0);
    }

    /**
     * 日期月份获取
     * @param date 日期 格式yyyy
     * @return 月MM
     */
    public static int getDateMonth(Date date){
        List<Integer> list = getDateCompose(date);
        return  list.get(1);
    }

    /**
     * 日期月份中的天数获取
     * @param date 日期 格式yyyy
     * @return 天dd
     */
    public static int getDateDay(Date date){
        List<Integer> list = getDateCompose(date);
        return  list.get(2);
    }

    /**
     * 日期相差天数
     * @param after
     * @param before
     * @return
     */
    public static int getBetweenDays(Date after,Date before){
        if(after == null)
            throw new RuntimeException(DateUtil.class.getName() + " getBetweenDay(Date after,Date before)，参数after不能为空");
        if(before == null){
            throw new RuntimeException(DateUtil.class.getName() + " getBetweenDay(Date after,Date before)，参数before不能为空");
        }

        Calendar c1 = new GregorianCalendar();
        c1.setTime(after);

        Calendar c2 = new GregorianCalendar();
        c2.setTime(before);

        int days = c1.get(Calendar.DAY_OF_YEAR)-c2.get(Calendar.DAY_OF_YEAR);

        int y1 = c1.get(Calendar.YEAR);
        int y2 = c2.get(Calendar.YEAR);

        if(c1.before(c2)) {
            while (y1 != y2) {
                c1.set(Calendar.YEAR, 1);
                days -= c1.getActualMaximum(Calendar.DAY_OF_YEAR);
                y1++;
            }
        }else{
            while (y1 != y2) {
                c1.set(Calendar.YEAR, -1);
                days += c1.getActualMaximum(Calendar.DAY_OF_YEAR);
                y1--;
            }
        }
        return days;
    }
}
