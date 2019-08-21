package com.lxgzhw.demo02.setName;

public class Demo01 {
    public static void main(String[] args) {
        //开启多线程
        MyThread myThread = new MyThread();
        myThread.setName("线程1");
        MyThread myThread2 = new MyThread("线程2");
        myThread.start();
        myThread2.start();
        System.out.println("-------------------------------");
    }
}
