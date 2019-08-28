package com.lxgzhw.demo01.FunctionalInterface;

/*
使用方法:
    1.作为方法的参数
    2.作为方法的返回值
 */
public class Demo01 {
    //方法1:参数
    static void show(FunctionInterface functionalInterface) {
        functionalInterface.method();
    }

    //入口测试方法
    public static void main(String[] args) {
        //函数式接口可以用Lambda表达式优化
        show(() -> System.out.println("这是函数式接口的好处."));
    }
}
