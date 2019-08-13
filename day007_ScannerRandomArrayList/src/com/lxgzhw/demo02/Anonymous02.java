package com.lxgzhw.demo02;

import java.util.Scanner;

public class Anonymous02 {
    public static void main(String[] args) {
        //匿名对象方法录入数据
        System.out.println("请输入一个数:");
        int num = new Scanner(System.in).nextInt();
        System.out.println("您输入的数是:" + num);


        //匿名对象方法作为参数
        System.out.println("-------------------------------");
        methodParam(new Scanner(System.in));

        //匿名对象作为返回值
        System.out.println("-------------------------------");
        System.out.println("请输入一个数:");
        int num1 = methodReturn().nextInt();
        System.out.println("您输入的数是:" + num1);
    }

    public static void methodParam(Scanner sc) {
        System.out.println("请输入一个数:");
        int num = sc.nextInt();
        System.out.println("输入的是:" + num);
    }

    //匿名对象作为返回值
    public static Scanner methodReturn() {
        return new Scanner(System.in);
    }
}
