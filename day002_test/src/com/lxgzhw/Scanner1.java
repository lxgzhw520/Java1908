package com.lxgzhw;
//1.导入录入依赖库

import java.util.Scanner;

public class Scanner1 {
    public static void main(String[] args) {
        //2.创建录入对象
        Scanner sc = new Scanner(System.in);
        //录入数据
        System.out.println("请输入年龄:");
        //3.接收用户输入
        int age = sc.nextInt();
        System.out.println("您输入的年龄是:" + age);
    }
}
