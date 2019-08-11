package com.lxgzhw;

import java.util.Scanner;

public class GuessNumber {
    public static void main(String[] args) {
        //猜数字小游戏
        guessNum();
    }

    //封装猜数字的方法
    public static void guessNum() {
        Scanner sc = new Scanner(System.in);
        //系统随机生成一个数字
        int secretNum = (int) (Math.random() * 100);
        while (true) {
            //让用户猜测
            System.out.println("请输入1-100之间的数字:");
            int userGuessNum = sc.nextInt();

            if (userGuessNum > secretNum) {
                System.out.println("猜大了.");
            }
            if (userGuessNum < secretNum) {
                System.out.println("猜小了.");
            }

            //退出条件
            if (secretNum == userGuessNum) {
                System.out.println("恭喜您,猜对了!");
                break;
            }
        }


    }
}
