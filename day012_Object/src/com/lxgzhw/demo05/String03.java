package com.lxgzhw.demo05;

public class String03 {
    public static void main(String[] args) {

        //字符串转整数
        String s1 = "1";
        int i = Integer.parseInt(s1);
        System.out.println(i);
        System.out.println("-------------------------------");

        //字符串转浮点数
        String s2 = "11.11";
        double i2 = Double.parseDouble(s2);
        System.out.println(i2);
        System.out.println("-------------------------------");


        //字符串转布尔值
        String s3 = "true";
        boolean i3 = Boolean.parseBoolean(s3);
        System.out.println(i3);
        System.out.println("-------------------------------");

    }
}
