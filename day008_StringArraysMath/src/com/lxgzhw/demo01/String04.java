package com.lxgzhw.demo01;

public class String04 {
    public static void main(String[] args) {
        //查看字符串的长度
        int length = "adfasdfas".length();
        System.out.println("字符串长度是:" + length);
        System.out.println("-------------------------------");


        //拼接字符串
        String hello = "Hello";
        String world = "World";
        String concat = hello.concat(world);//全新字符串
        System.out.println(hello);//不会改变
        System.out.println(world);//不会改变
        System.out.println(concat);
        System.out.println("-------------------------------");

        //获取指定位置的单个字符
        char c = "Hello".charAt(1);
        System.out.println("1号位置是:" + c);
        System.out.println("-------------------------------");

        //查找参数字符串在源字符串中出现的位置
        //没有返回-1
        int helloIndex = "Hello world!".indexOf("Hello");
        System.out.println("Hello在字符串中的索引位置是:" + helloIndex);
        System.out.println("-------------------------------");



    }
}
