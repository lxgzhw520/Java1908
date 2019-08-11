package com.lxgzhw;

import java.util.Scanner;

public class HomeWork02 {
    public static void main(String[] args) {
        //求1/1+1/2+1/3+....+1/n  (n>=2)的和
        Scanner sc = new Scanner(System.in);
        System.out.print("请输入n = ");
        int n = sc.nextInt();
        System.out.println();

        //开始计算
        double sum = 0;//总和
        for (double i = 0; i < n; i++) {
            sum += (1 / (i + 1));
        }
        System.out.println("1/1+1/2+1/3+....+1/n  (n>=2)的和为:" + sum);
    }
}
