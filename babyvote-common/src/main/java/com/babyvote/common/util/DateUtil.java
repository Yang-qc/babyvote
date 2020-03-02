package com.babyvote.common.util;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 *  10位的时间戳和日期转换工具类
 **/
public class DateUtil {
    public static String timeStamp2Date(String seconds, String format) {
        if (seconds == null || seconds.isEmpty() || seconds.equals("null")) {
            return "";
        }
        if (format == null || format.isEmpty()) {
            format = "yyyy-MM-dd HH:mm:ss";
        }
        SimpleDateFormat sdf = new SimpleDateFormat(format);
        return sdf.format(new Date(Long.valueOf(seconds + "000")));
    }


    /**
     * 日期格式字符串转换成时间戳
     *
     * @param date_str 字符串日期
     */
    public static String date2TimeStamp(String date_str, String format) {
        try {
            SimpleDateFormat sdf = new SimpleDateFormat(format);
            return String.valueOf(sdf.parse(date_str).getTime() / 1000);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return "";
    }


    /**
     * 取得当前时间戳（精确到秒）
     *
     * @return
     */
    public static String timeStamp() {
        long time = System.currentTimeMillis();
        String t = String.valueOf(time / 1000);
        return t;
    }

    /**
     * 调用该方法可以直接返回String类型的十位数时间错
     * @return
     */
    public static String getDateUtil(){
        //取得当前时间戳（精确到秒）
        String timeStamp = timeStamp();
        //返回当前的计算机时间
        String date = timeStamp2Date(timeStamp, "yyyy-MM-dd HH:mm:ss");
        //日期格式字符串转换成时间戳
        String timeStamp2 = date2TimeStamp(date, "yyyy-MM-dd HH:mm:ss");
        System.out.println("10位的时间戳：【"+timeStamp2+"】");
        return timeStamp2;
    }

    public static void main(String[] args) {
        String timeStamp = timeStamp();
        System.out.println("timeStamp=" + timeStamp);
        System.out.println(System.currentTimeMillis());
        //该方法的作用是返回当前的计算机时间，时间的表达格式为当前计算机时间和GMT时间(格林威治时间)1970年1月1号0时0分0秒所差的毫秒数
        String date = timeStamp2Date(timeStamp, "yyyy-MM-dd HH:mm:ss");
        System.out.println("date=" + date);
        String timeStamp2 = date2TimeStamp(date, "yyyy-MM-dd HH:mm:ss");
        System.out.println(timeStamp2);
        //测试
//        String num=getDateUtil();
//        System.out.println(num);
    }


}
