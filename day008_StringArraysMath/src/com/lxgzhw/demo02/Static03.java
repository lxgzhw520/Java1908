package com.lxgzhw.demo02;

public class Static03 {
    static {
        System.out.println("静态代码块执行.");
        System.out.println("-------------------------------");
    }

    public Static03() {
        System.out.println("构造方法执行.");
    }

    public static void main(String[] args) {
        //测试
        Static03 s1 = new Static03();
        Static03 s2 = new Static03();
        Static03 s3 = new Static03();
    }
}
