package com.lxgzhw.demo01;

public class String03 {
    public static void main(String[] args) {
        //比较两个对象的值是否一样
        String s1 = "hello";
        String s2 = "hello";
        String s4 = "Hello";
        char[] chars = {'h', 'e', 'l', 'l', 'o'};
        String s3 = new String(chars);

        //比较
        System.out.println(s1.equals(s2));//true
        System.out.println(s1.equals(s3));//true
        System.out.println(s2.equals(s3));//true

        //忽略大小写
        System.out.println(s4.equalsIgnoreCase(s2));
    }
}
