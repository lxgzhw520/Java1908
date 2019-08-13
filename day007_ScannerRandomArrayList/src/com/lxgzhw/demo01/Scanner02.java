package com.lxgzhw.demo01;

import java.util.Scanner;

public class Scanner02 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("请输入第1个数:");
        int num1 = sc.nextInt();
        System.out.println("请输入第2个数:");
        int num2 = sc.nextInt();
        //求和
        int sum = num1 + num2;
        //打印
        System.out.println(num1 + " + " + num2 + " = " + sum);
    }
}
