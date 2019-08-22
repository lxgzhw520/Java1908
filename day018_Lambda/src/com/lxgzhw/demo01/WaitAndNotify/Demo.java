package com.lxgzhw.demo01.WaitAndNotify;

/*
测试类
 */
public class Demo {
    public static void main(String[] args) {
        //1.创建包子
        SteamedStuffedBun steamedStuffedBun = new SteamedStuffedBun();
        //2.创建包子铺线程,生产包子
        new Costs(steamedStuffedBun).start();
        //3.创建消费者线程,吃包子
        new Customer(steamedStuffedBun).start();
    }
}
