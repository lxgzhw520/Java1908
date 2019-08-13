package com.lxgzhw.demo01;

import java.util.Scanner;

public class Scanner03 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("请输入第一个数:");
        int num1 = sc.nextInt();
        System.out.println("请输入第二个数:");
        int num2 = sc.nextInt();
        System.out.println("请输入第三个数:");
        int num3 = sc.nextInt();

        //开始比较
        int max = num1;
        if (max < num2) {
            max = num2;
        }
        if (max < num3) {
            max = num3;
        }

        //打印
        System.out.println(num1 + ", " + num2 + ", "
                + num3 + " 中的最大值是:" + max);
    }
}
