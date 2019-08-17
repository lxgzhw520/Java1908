package com.lxgzhw.demo03.Generic;

public class Demo03Generic {
    public static void main(String[] args) {
        //创建泛型方法所在的类的实例
        GenericMethod genericMethod = new GenericMethod();
        //调用泛型方法
        //可以传任意数据类型
        genericMethod.method(11);
        genericMethod.method("字符串");
        genericMethod.method(true);
        genericMethod.method(33.3333);
        System.out.println("-------------------------------");

        //静态方法无法通过对象调用
        //只能通过类名调用
        GenericMethod.method2("也可以是任意数据类型");
        GenericMethod.method2(333);
        GenericMethod.method2(false);
        System.out.println("-------------------------------");
    }
}
