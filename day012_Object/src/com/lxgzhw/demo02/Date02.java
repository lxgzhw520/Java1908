package com.lxgzhw.demo02;

import java.util.Date;

public class Date02 {
    public static void main(String[] args) {
        //构造方法
        Date date = new Date();
        //得到当前日期
        System.out.println(date);
        System.out.println("-------------------------------");


        //带参构造方法
        //将毫秒值转换为日期
        Date date1 = new Date(System.currentTimeMillis());
        System.out.println(date1);

        //常用方法 getTime() 当前时间毫秒值
        System.out.println(new Date().getTime());
        System.out.println(new Date(new Date().getTime()));
    }
}
