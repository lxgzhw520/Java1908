package com.lxgzhw.demo05.innerClass;

public class Demo01 {
    public static void main(String[] args) {
        //注意:主线程优先执行,所以分割线打印会提前
        //匿名内部类实现多线程的创建
        new Thread() {
            @Override
            public void run() {
                for (int i = 0; i < 20; i++) {
                    System.out.println("当前线程名称:" + Thread.currentThread().getName());
                }
            }
        }.start();
        //使用接口
        System.out.println("-------------------------------");
        new Thread(new Runnable() {
            @Override
            public void run() {
                for (int i = 0; i < 20; i++) {
                    System.out.println("当前线程:" + Thread.currentThread().getName());
                }
            }
        }).start();
    }
}
