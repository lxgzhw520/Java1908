package com.lxgzhw.demo01;

import java.util.Scanner;

public class Practice02 {
    public static void main(String[] args) {
        //键盘输入一个字符串,统计其中各种字符出现的次数
        //种类有: 大写字母,小写字母,数字,其他
        Scanner sc = new Scanner(System.in);
        //1.录入一个字符串
        System.out.println("请输入一个字符串:");
        String next = sc.next();
        //2.调用统计方法
        countString(next);
    }

    //定义统计方法
    static void countString(String str) {
        //1.将字符串转换为字符数组
        char[] chars = str.toCharArray();
        //2.遍历字符数组,调用字符方法判断
        //2.1 isDigit()判断是否为数字
        //2.2 isUpperCase()判断是否为大写字母
        //2.3 isLowerCase()判断是否为小写字母
        //2.4 不是以上三者归为其他
        int digit = 0, upper = 0, lower = 0, other = 0;
        for (int i = 0; i < chars.length; i++) {
            if (Character.isDigit(chars[i])) {
                digit++;
            } else if (Character.isUpperCase(chars[i])) {
                upper++;
            } else if (Character.isLowerCase(chars[i])) {
                lower++;
            } else {
                other++;
            }
        }
        System.out.println("字符串是:" + str);
        System.out.println("数字共有:" + digit + "个");
        System.out.println("大写字母共有:" + upper + "个");
        System.out.println("小写字母共有:" + lower + "个");
        System.out.println("其他字符共有:" + other + "个");

        //3.打印
    }
}
