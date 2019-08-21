package com.lxgzhw.demo07.Synchronized;

public class Demo {
    public static void main(String[] args) {
        //创建接口实现类对象
        RunnableImpl runnable = new RunnableImpl();
        //创建3个线程同时卖票
        Thread thread01 = new Thread(runnable);
        Thread thread02 = new Thread(runnable);
        Thread thread03 = new Thread(runnable);
        //开启多线程
        thread01.start();
        thread02.start();
        thread03.start();
    }
}
