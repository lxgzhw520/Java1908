package com.lxgzhw.demo03.Lambda;
import com.lxgzhw.demo02.ThreadPool.RunnableImpl;
public class Demo01Runnable {
    public static void main(String[] args) {
        //使用前面的接口实现类
        RunnableImpl runnable = new RunnableImpl();
        //创建新线程的方法1
        Thread thread = new Thread(runnable);
        thread.start();

        //创建多线程的方法2
        Runnable runnable1 = new Runnable() {
            @Override
            public void run() {
                System.out.println("创建了新线程.");
            }
        };
        new Thread(runnable1).start();

        //创建多线程的方法3
        new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println("创建了新线程.");
            }
        }).start();


    }
}
