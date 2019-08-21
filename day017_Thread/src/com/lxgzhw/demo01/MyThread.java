package com.lxgzhw.demo01;

/*
获取线程的名称:
    1.使用Thread类中的getName()方法
    2.先获取正在执行的线程,再通过该线程获取名称
        currentThread()
 */
public class MyThread extends Thread {
    @Override
    public void run() {
        //重写run方法
        System.out.println("当前线程的名称:"
                + Thread.currentThread().getName());
    }
}
