package com.lxgzhw.demo01;

public class getName {
    public static void main(String[] args) {
        //1.获取Thread的子类对象
        MyThread myThread = new MyThread();
        //2.调用start方法,开启新线程,执行run方法
        myThread.start();

        System.out.println("-------------------------------");
        //匿名调用
        new MyThread().start();
        new MyThread().start();
        System.out.println("-------------------------------");
        System.out.println(Thread.currentThread().getName());

    }
}
