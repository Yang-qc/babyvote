package com.babyvote.common.util;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * 特殊时间处理:2019-01-31T16:00:00.000+0000
 *
 */
public class getDateFormat {
    public static String dealDateFormat(String oldDate) {
//        Date date1 = null;
//        DateFormat df2 = null;
//        try {
//            DateFormat df = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss");
//            Date date = df.parse(oldDate);
//            SimpleDateFormat df1 = new SimpleDateFormat ("EEE MMM dd HH:mm:ss Z yyyy", Locale.UK);
//            date1 = df1.parse(date.toString());
//            df2 = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
//        } catch (ParseException e) {
//            e.printStackTrace();
//        }
        Date time =new Date(oldDate);
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        return sdf.format(time);
    }
}
