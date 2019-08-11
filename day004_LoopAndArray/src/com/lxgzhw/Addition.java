package com.lxgzhw;

import java.util.Scanner;

public class Addition {
    public static void main(String[] args) {
        //随机加法答题器
        int score = 0;//得分
        // 答对1题加10分
        // 连续答对多少题就加多少分
        int continueNum = 0;//连续答对次数
        int spendTime = 0;//消耗时间(秒)
        int startTime = 0;//答题开始时间
        int endTime = 0;//答题结束时间
        int systemStartTime = 0;//系统开始时间
        int systemEndTime = 0;//系统结束时间
        int problemNum = 0;//题目数量
        Scanner sc = new Scanner(System.in);//录入对象
        //两个数的加法
        int num1 = 0;//第一个数
        int num2 = 0;//第二个数
        int result = 0;//结果
        int userResult = 0;//用户输入的结果

        //选择题目数量
        System.out.println("请选择题目的数量(10/20/30/50):");
        problemNum = sc.nextInt();
        //记录系统开始时间
        systemStartTime = (int) System.currentTimeMillis();
        for (int i = 0; i < problemNum; i++) {
            num1 = (int) (Math.random() * 10000);
            num2 = (int) (Math.random() * 10000);

            //开始出题
            System.out.println("题目" + (i + 1) + ":");
            System.out.println(num1 + " + " + num2 + " =");
            //答题开始时间
            startTime = (int) System.currentTimeMillis();
            result = num1 + num2;
            userResult = sc.nextInt();
            endTime = (int) System.currentTimeMillis();
            //消耗时间
            spendTime = (endTime - startTime) / 10000;
            System.out.println("本次答题时间为:" + spendTime + "秒");
            System.out.println("您的答案是:" + userResult);
            System.out.println("正确答案是:" + result);
            //判断是否回答正确
            if (userResult == result) {
                System.out.println("恭喜您回答正确.");
                score += 10;//本来的分
                score += continueNum;//连续答对得分
                continueNum++;
            } else {
                System.out.println("很遗憾,回答错误!");
                continueNum = 0;
            }

            //退出条件
//            break;

        }
        //记录系统结束时间
        systemEndTime = (int) System.currentTimeMillis();
        System.out.println("本次答题总共消耗时间为:" + ((systemEndTime - systemStartTime) / 10000) + "秒.");
    }
}
