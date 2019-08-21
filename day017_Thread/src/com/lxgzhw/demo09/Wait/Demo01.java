package com.lxgzhw.demo09.Wait;

public class Demo01 {
    public static void main(String[] args) {
        //唤醒线程
        //创建锁对象,保证唯一
        final Object obj = new Object();

        //创建一个顾客线程
        new Thread() {
            @Override
            public void run() {
                //一直等着买包子
                while (true) {
                    //保证等待和唤醒的线程只有一个执行
                    //同步技术
                    synchronized (obj) {
                        System.out.println("顾客1在消费");
                        //调用wait方法
                        //放弃cpu的执行
                        //进入到waiting状态
                        try {
                            obj.wait();
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                        //唤醒之后执行的代码
                        System.out.println("包子做好了,顾客1开始吃");
                        System.out.println("-------------------------------");
                    }
                    System.out.println("顾客1吃完了");
                    break;
                }
            }
        }.start();

        //创建另一个顾客线程
        new Thread() {
            @Override
            public void run() {
                //顾客2能吃两份包子
                int count = 0;
                //一直等着买包子
                while (true) {
                    //保证等待和唤醒的线程只有一个执行
                    //同步技术
                    synchronized (obj) {
                        System.out.println("顾客2在消费");
                        //调用wait方法
                        //放弃cpu的执行
                        //进入到waiting状态
                        try {
                            obj.wait();
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                        //唤醒之后执行的代码
                        System.out.println("包子做好了,顾客2开始吃");
                        System.out.println("-------------------------------");
                    }
                    if (count > 2) {
                        System.out.println("顾客2吃了两份包子,吃饱了,走了");
                        break;
                    }
                    count++;
                }
            }
        }.start();

        //创建老板线程
        new Thread() {
            @Override
            public void run() {
                while (true) {
                    //花了1秒钟做包子
                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    synchronized (obj) {
                        System.out.println("老板把包子做好了");
                        //obj.notify();//随机唤醒一个
                        //唤醒全部
                        obj.notifyAll();
                    }
                }
            }
        }.start();

    }
}
