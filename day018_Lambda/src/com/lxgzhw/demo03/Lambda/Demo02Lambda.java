package com.lxgzhw.demo03.Lambda;

public class Demo02Lambda {
    public static void main(String[] args) {
        //Lambda表达式实际上JavaScript中的函数新型表达式
        //格式 ()->{}
        //实现多线程的测试

        //方法1
        new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println("匿名内部类的多线程.");
            }
        }).start();
        System.out.println("-------------------------------");
        //方法2
        new Thread(() -> {
            System.out.println("Lambda表达式多线程");
        }).start();
        System.out.println("-------------------------------");
        //方法3
        new Thread(() -> System.out.println("如果函数体" +
                "只有一行,可以省略大括号.")).start();
        System.out.println("-------------------------------");
    }
}
