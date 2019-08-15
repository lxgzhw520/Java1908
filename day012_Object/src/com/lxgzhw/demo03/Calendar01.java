package com.lxgzhw.demo03;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class Calendar01 {
    public static void main(String[] args) {
        //获取日历类的实例
        Calendar calendar = Calendar.getInstance();
        System.out.println(calendar);
        System.out.println("-------------------------------");

        //年月日时分秒
        //YEAR MONTH DATE DAY_OF_MONTH HOUR MINUTE SECOND
        //get 返回给定的日历字段值
        int year = calendar.get(Calendar.YEAR);
        System.out.println("年份:" + year);
        System.out.println("-------------------------------");

        //set 设定给定的日历字段值
        calendar.set(Calendar.YEAR, 2020);
        year = calendar.get(Calendar.YEAR);
        System.out.println("修改后年份:" + year);
        System.out.println("-------------------------------");

        //打印日历
        System.out.println(calendar.toString());
        System.out.println("-------------------------------");

        //同时设置年月日
        calendar.set(2012, 5, 21);

        //增加或减少指定的字段
        calendar.add(Calendar.YEAR, -2);
        year = calendar.get(Calendar.YEAR);
        System.out.println("年份:" + year);
        System.out.println("-------------------------------");


        //把日历对象转换为日期对象
        Date time = calendar.getTime();
        //格式化
        String format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(time);
        System.out.println(format);

    }
}
