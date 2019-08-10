package com.lxgzhw;

public class Operator01 {
    public static void main(String[] args) {
        int num1 = 11;
        int num2 = 22;

        System.out.println("加法:" + (num1 + num2));
        System.out.println("减法:" + (num1 - num2));
        System.out.println("乘法:" + (num1 * num2));
        System.out.println("除法:" + (num1 / num2));
        //取余,除不尽的,结果就是自己
        System.out.println("取余:" + (num1 % num2));
        System.out.println("取余:" + (num1 % 33));
        System.out.println("取余:" + (num1 % 55));
    }
}
