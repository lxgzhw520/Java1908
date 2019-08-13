package com.lxgzhw.demo03;

import java.util.Random;
import java.util.Scanner;

public class Random04 {
    public static void main(String[] args) {
        //统计时间
        double spendTime = 0;
        //统计次数
        int count = 0;
        //创建随机数
        Random r = new Random();
        //创建录入对象
        Scanner sc = new Scanner(System.in);

        //生成一个随机数
        int randomNum = r.nextInt(100);

        //开始时间
        double startTime = (double) System.currentTimeMillis();
        //让用户猜测
        while (true) {
            System.out.println("请输入一个0-100之间的数:");
            int userNum = sc.nextInt();
            //大了
            if (userNum > randomNum) {
                System.out.println("大了.");
            }
            //小了
            if (userNum < randomNum) {
                System.out.println("小了.");
            }
            //退出循环
            if (randomNum == userNum) {
                System.out.println("恭喜您猜对了.");
                break;
            }
            count++;
        }
        double endTime = (double) System.currentTimeMillis();
        //统计数据
        spendTime = endTime - startTime;
        spendTime /= 10000;
        System.out.println("共猜测:" + count + "次.");
        System.out.println("共消耗时间:" + spendTime + "秒");
    }
}
