package com.lxgzhw.demo01;
//1.导入包

import java.util.Scanner;

public class Scanner01 {
    public static void main(String[] args) {
        //2.创建对象
        //备注:System.in代表从键盘进行输入
        Scanner sc = new Scanner(System.in);

        //3.获取键盘输入的int数字
        System.out.println("请输入一个数字:");
        int num = sc.nextInt();
        System.out.println("输入的int数字是:" + num);

        //4.获取键盘输入的字符串
        System.out.println("请输入一个字符串:");
        String str = sc.next();
        System.out.println("您输入的字符串是:" + str);
    }
}
