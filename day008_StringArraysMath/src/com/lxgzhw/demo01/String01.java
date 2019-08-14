package com.lxgzhw.demo01;

public class String01 {
    public static void main(String[] args) {
        //创建字符串的几种方法
        String s1 = new String();//空参构造
        System.out.println("第一个字符串:" + s1);
        System.out.println("-------------------------------");

        //根据字符数组创建字符串
        char[] charArray = {'a', 'b', 'c'};
        String s2 = new String(charArray);
        System.out.println("第二个字符串:" + s2);
        System.out.println("-------------------------------");

        //根据字节数组创建字符串
        byte[] byteArray = {67, 68, 69};
        String s3 = new String(byteArray);
        System.out.println("第三个字符串:" + s3);
        System.out.println("-------------------------------");

        //直接创建
        String s4 = "直接创建";
        System.out.println("第四个字符串:" + s4);
    }
}
