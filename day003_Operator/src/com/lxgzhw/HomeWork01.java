package com.lxgzhw;

import java.util.Scanner;

public class HomeWork01 {
    public static void main(String[] args) {
        //录入两个数,输出最大值
        Scanner sc = new Scanner(System.in);

        System.out.println("请输入第一个数:");
        int num1 = sc.nextInt();
        System.out.println("请输入第二个数:");
        int num2 = sc.nextInt();

        int max;
        if (num1 > num2) {
            max = num1;
        } else {
            max = num2;
        }

        //输出
        System.out.println("您输入的两个数分别为:" + num1 + "," + num2);
        System.out.println("其中最大的数为:" + max);
    }
}
