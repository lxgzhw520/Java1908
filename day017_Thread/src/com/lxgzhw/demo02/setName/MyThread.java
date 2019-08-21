package com.lxgzhw.demo02.setName;
/*
设置线程的名称:
    1.setName
    2.构造方法
 */
public class MyThread extends Thread {
    public MyThread() {
    }

    public MyThread(String name) {
        super(name);
    }

    @Override
    public void run() {
        System.out.println("当前线程的名字:"+Thread.currentThread().getName());
    }
}
