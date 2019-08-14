package com.lxgzhw.demo03;

import java.util.Arrays;
import java.util.Scanner;

public class Arrays02 {
    public static void main(String[] args) {
        //将一个随机字符串中的所有字符升序排列,并倒序打印
        //1.随便录入一个字符串
        Scanner sc = new Scanner(System.in);
        System.out.println("请输入任意字符串:");
        String s = sc.next();
        //2.调用字符串打印方法
        printString(s);
    }

    //字符串打印方法
    static void printString(String str) {
        //1.将字符串转换为字符数组
        char[] chars = str.toCharArray();
        //2.使用Arrays.sort()方法对数组进行升序
        Arrays.sort(chars);
        //3.遍历排序后的方法,倒序打印
        for (int i = chars.length - 1; i >= 0; i--) {
            System.out.print(chars[i] + "\t");
        }
    }
}
