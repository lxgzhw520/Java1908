package com.lxgzhw.demo07;

import java.util.ArrayList;
import java.util.Random;

//普通成员
public class Member extends User {
    public Member() {
    }

    public Member(String name, double money) {
        super(name, money);
    }
    //收红包的方法
    public void receive(ArrayList<Double> list){
        //随机从红包中抽取一个
        Random r=new Random();
        int i = r.nextInt(list.size());
        //根据索引,从集合中删除元素,并得到被删除的红包
        //Double redPackageMoney = list.get(i);
        Double redPackageMoney = list.remove(i);
        double money = super.getMoney();
        money+=redPackageMoney;
        super.setMoney(money);
    }
}
