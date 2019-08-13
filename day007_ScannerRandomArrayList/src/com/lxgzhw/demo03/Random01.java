package com.lxgzhw.demo03;

import java.util.Random;

public class Random01 {
    public static void main(String[] args) {
        Random r = new Random();
        //生成随机数
        int num1 = r.nextInt();
        System.out.println("生成的随机数是:" + num1);

        //生成指定范围的随机数
        System.out.println("-------------------------------");
        int num2 = r.nextInt(101);
        System.out.println("生成的随机数是:" + num2);

        //另一种生成随机数的方法
        System.out.println("-------------------------------");
        int num3 = (int) (Math.random() * 100);
        System.out.println("生成的随机数是:" + num3);
    }
}
