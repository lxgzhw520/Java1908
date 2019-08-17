package com.lxgzhw.demo03.Generic;

public class GenericInterfaceImpl1 implements GenericInterface<String> {
    @Override
    public void method(String i) {
        System.out.println("接收字符串作为参数");
        System.out.println(i);
        System.out.println("-------------------------------");
    }
}
