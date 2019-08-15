package com.lxgzhw.demo05;

public class String02 {
    public static void main(String[] args) {
        //基本类型和字符串之间的转换
        //其他类型转字符串
        int i = 111;
        String s = String.valueOf(i);
        System.out.println(s);
        System.out.println("-------------------------------");


        double i1=11.111;
        String s1 = String.valueOf(i1);

        boolean i2=true;
        String s2 = String.valueOf(i2);

        float i3=333.333F;
        String s3 = String.valueOf(i3);
    }
}
