package com.lxgzhw.demo06.ThreadSafe;

public class RunnableImpl implements Runnable {
    private int ticket = 100;
    Object obj = new Object();

    //设置线程任务
    @Override
    public void run() {
        while (ticket > 0) {
            //同步代码块,解决线程安全问题
            System.out.println(Thread.currentThread().getName() + "正在卖票" + ticket);
            ticket--;
        }
    }

}
