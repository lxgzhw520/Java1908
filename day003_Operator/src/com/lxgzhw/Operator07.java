package com.lxgzhw;

import java.util.Scanner;

public class Operator07 {
    public static void main(String[] args) {
        //判断是否为闰年
        System.out.println("请输入年份:");
        Scanner sc = new Scanner(System.in);
        int year = sc.nextInt();
        //能被4整除且不能100整除 或能够被400整除
        if (year % 4 == 0 && year % 100 != 0 || year % 400 == 0) {
            System.out.println(year + "是闰年");
        } else {
            System.out.println(year + "不是闰年");
        }
    }
}
