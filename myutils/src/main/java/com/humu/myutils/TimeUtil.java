package com.humu.myutils;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

/**
 * Created by Administrator on 2019/1/24.
 */

public class TimeUtil {

    private TimeUtil(){}

    /**
     * 将时间转换为时间戳
     * @param time
     * @return
     */
    public static long parseTimeToLong(String time){
        Date date;
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
        try {
            date = simpleDateFormat.parse(time);
            return date.getTime();
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return 0;
    }

    /**
     * 将时间戳转换为星期几
     * @param time
     * @return 日一二三四五六 -> 0123456
     */
    public static int getDayOfWeek(long time){
        Calendar calendar = Calendar.getInstance();
        calendar.setTimeInMillis(time);
        return calendar.get(Calendar.DAY_OF_WEEK) - 1;
    }

}
