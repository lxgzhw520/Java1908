package com.lxgzhw.demo01;

public class String05 {
    public static void main(String[] args) {
        String s = "Hello world";

        //截取方法1
        String s1 = s.substring(s.indexOf("w"));
        System.out.println(s1);
        System.out.println("-------------------------------");

        //截取方法2
        //左包右不包,所以,右边需要加一
        String s3 = s.substring(s.indexOf('w'), s.indexOf('d') + 1);
        System.out.println(s3);
        System.out.println("-------------------------------");
    }
}
