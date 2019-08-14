package com.lxgzhw.demo01;

public class String02 {
    public static void main(String[] args) {
        String s1 = "aaa";
        String s2 = "aaa";
        char[] chars = {'a', 'a', 'a'};
        String s3 = new String(chars);

        //判断是否一样
        // == 比较的是地址值
        System.out.println(s1 == s2);//true
        System.out.println(s1 == s3);//false
        System.out.println(s2 == s3);//false
    }
}
