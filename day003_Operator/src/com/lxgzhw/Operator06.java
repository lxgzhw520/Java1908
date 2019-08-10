package com.lxgzhw;

import java.util.Scanner;

public class Operator06 {
    public static void main(String[] args) {
        //判断年龄是否在18到50之间
        System.out.println("请输入您的年龄:");
        Scanner sc = new Scanner(System.in);
        int age = sc.nextInt();
        if (age > 18 && age < 50) {
            System.out.println("年龄在18-50之间");
        } else {
            System.out.println("年龄在18-50之间");
        }
    }
}
