package com.lxgzhw.demo05.Practice01;

public class Demo {
    public static void main(String[] args) {
        //练习1
        //使用lambda表达式简写接口实现方法
        //接口参数方法
        invokeCook(() -> System.out.println("做饭"));
    }

    private static void invokeCook(Cook cook) {
        cook.cookAMeal();
    }
}
