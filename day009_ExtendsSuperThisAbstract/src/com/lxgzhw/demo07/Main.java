package com.lxgzhw.demo07;

import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        Manager manager = new Manager("群主", 10000);
        Member cuFeng = new Member("楚枫", 100);
        Member cuiCui = new Member("萃萃", 100);
        Member daHuang = new Member("大黄", 0);

        //群主发红包
        ArrayList<Double> redPackage = manager.send(100, 3);
        //普通成员收红包
        cuFeng.receive(redPackage);
        cuiCui.receive(redPackage);
        daHuang.receive(redPackage);

        //查看余额
        System.out.println("群主:" + manager.getMoney());
        System.out.println("楚枫:" + cuFeng.getMoney());
        System.out.println("萃萃:" + cuiCui.getMoney());
        System.out.println("大黄:" + daHuang.getMoney());
    }
}
