package com.lxgzhw.demo07;

import java.util.ArrayList;

//群主类
public class Manager extends User {
    public Manager() {
    }

    public Manager(String name, double money) {
        super(name, money);
    }
    //发红包的方法
    public ArrayList<Double> send(double totalMoney,double count){
        //存储若干个红包的集合
        ArrayList<Double> redPackageList = new ArrayList<>();

        //首先看一下群主自己有多少钱
        double leftMoney=super.getMoney();

        //如果余额不足,直接返回
        if (leftMoney<totalMoney){
            System.out.println("余额不足");
            return redPackageList;
        }
        //扣钱
        leftMoney-=totalMoney;
        super.setMoney(leftMoney);

        //发红包需要拼接拆分为count份
        double avg=totalMoney/count;

        //把红包放到集合中
        for (int i = 0; i < count; i++) {
            redPackageList.add(avg);
        }
        //打印红包
        System.out.println("-------------------------------");
        System.out.println("红包:");
        System.out.println(redPackageList);
        System.out.println("-------------------------------");

        //返回红包集合
        return redPackageList;
    }
}
