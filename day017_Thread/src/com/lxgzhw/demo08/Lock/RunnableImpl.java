package com.lxgzhw.demo08.Lock;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class RunnableImpl implements Runnable {
    private int ticket = 10000;
    //多态方法创建锁
    Lock l = new ReentrantLock();

    @Override
    public void run() {
        //解决线程安全问题的方案2  锁
        //最通用方法方法 必须记住
        //需要根据线程数量来判断大于多少
        while (true) {
            //判断必须写在无限循环内部
            //写在外部会出现访问不存在资源问题
            if (ticket > 3) {
                //上锁
                l.lock();

                //中间过程被安全的锁住
                System.out.println(Thread.currentThread().getName() + "" +
                        "正在卖票:" + ticket);
                ticket--;

                //解锁
                l.unlock();
            } else {
                break;
            }
        }
    }
}
