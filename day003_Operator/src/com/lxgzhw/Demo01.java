package com.lxgzhw;

import java.util.Scanner;

public class Demo01 {
    public static void main(String[] args) {
        //柜台收银程序
        Scanner sc = new Scanner(System.in);
        System.out.println("请输入单价:");
        double unitPrice = sc.nextDouble();
        System.out.println("请输入数量:");
        double amount = sc.nextDouble();


        //计算总价(单价*数量)
        double totalPrice = unitPrice * amount;
        System.out.println("总价为:" + totalPrice);

        //打折(八折)
        totalPrice *= 0.8;
        System.out.println("折后价格为:" + totalPrice);

        System.out.println("请输入支付金额:");
        double money = sc.nextDouble();
        //计算找零(支付金额-总价)
        double change = money - totalPrice;
        System.out.println("您支付了:" + money + "元");
        System.out.println("找您" + change + "元");

    }
}
