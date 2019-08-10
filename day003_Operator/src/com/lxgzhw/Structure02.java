package com.lxgzhw;

import java.util.Scanner;

public class Structure02 {
    public static void main(String[] args) {
        //成年人可以进网吧,未成年人进制进网吧
        System.out.println("请输入年龄:");

        Scanner sc = new Scanner(System.in);
        int age = sc.nextInt();

        if (age >= 18) {
            System.out.println("成年人可以进网吧.");
        } else {
            System.out.println("未成年人禁止进网吧.");
        }
    }
}
