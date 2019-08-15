package com.lxgzhw.demo02;

public class Date01 {
    public static void main(String[] args) {
        //当前系统时间到时间原点的毫秒值
        long time = System.currentTimeMillis();

        //把毫秒转换为日期
        time /= 1000;
        time /= 3600;
        time /= 24;
        System.out.println(time);
    }
}
