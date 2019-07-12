package com.example.geek.utils;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class DateUtil {

    //获取当前年
    public static int getCurrentYear(){
        Calendar calendar = Calendar.getInstance();
        return calendar.get(Calendar.YEAR);
    }

    //获取当前月
    public static int getCurrentMonth(){
        Calendar calendar = Calendar.getInstance();
        return calendar.get(Calendar.MONTH);
    }

    //获取当前日
    public static int getCurrentDay(){
        Calendar calendar = Calendar.getInstance();
        return calendar.get(Calendar.DATE);
    }

    public static String getYYYYMMDD(){
        Date date = new Date();
        SimpleDateFormat yyyyMMdd = new SimpleDateFormat("yyyyMMdd");
        return yyyyMMdd.format(date);
    }

}
