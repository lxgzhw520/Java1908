package com.lxgzhw.demo07.Synchronized;

/*
实现Runnable接口创建多线程程序的好处:
    1.避免了单继承的局限性
        一个类只能继承一个类,类继承了Thread类就不能继承其他的类
        实现了Runnable接口,还可以继承其他的类,实现其他的接口
    2.增强了程序的扩展性,降低了程序的耦合性(解耦)
        实现Runnable接口的方式,把设置线程任务和开启新线程进行了分离(解耦)
        实现类中,重写了run方法:用来设置线程任务
        创建Thread类对象,调用start方法:用来开启新线程
 */
public class RunnableImpl implements Runnable {
    //卖票案例:3个卖票人员同时卖票
    //定义一个多线程共享的票源
    private int ticket = 1000;
    //创建一个锁对象
    Object obj = new Object();

    //设置线程任务
    @Override
    public void run() {
        while (true) {
            if (ticket > 2) {
                //同步代码块,解决线程安全问题的方法1
                synchronized (obj) {
                    System.out.println(Thread.currentThread().getName() + "正在卖票:" + ticket);
                    ticket--;
                }
            }else {
                break;
            }
        }
    }
}
