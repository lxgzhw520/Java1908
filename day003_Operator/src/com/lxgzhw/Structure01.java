package com.lxgzhw;

import java.util.Scanner;

public class Structure01 {
    public static void main(String[] args) {
        //录入分数,如果大于等于60分则输出及格
        Scanner sc = new Scanner(System.in);
        System.out.println("请输入分数:");
        double score = sc.nextDouble();
        if (score >= 60) {
            System.out.println("及格了.");
        }
    }
}
