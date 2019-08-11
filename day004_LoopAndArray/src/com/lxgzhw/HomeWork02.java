package com.lxgzhw;

import java.util.Scanner;

public class HomeWork02 {
    public static void main(String[] args) {
        //根据年份 计算天数
        //1 3 5 7 8 10 12  --->>> 31天
        //4 6 9 11         --->>> 30天
        //2                --->>> 28天/29天
        Scanner sc = new Scanner(System.in);
        //录入年份和月份
        System.out.println("请输入年份:");
        int year = sc.nextInt();
        //根据年份和月份计算天数
        System.out.println("请输入月份:");
        int month = sc.nextInt();

        int days = 0;//用来记录天数

        // 计算天数
        switch (month) {
            case 1:
            case 3:
            case 5:
            case 7:
            case 8:
            case 10:
            case 12:
                days = 31;
                break;
            case 4:
            case 6:
            case 9:
            case 11:
                days = 30;
                break;
            case 2:
                //判断是否为闰年
                if (year % 4 == 0 && year % 100 != 0 || year % 400 == 0) {
                    //闰年2月29天
                    days = 29;
                } else {
                    days = 28;
                }
        }


        //输出结果
        System.out.println(year + "年" + month + "月的天数为:" + days + "天");
    }
}
