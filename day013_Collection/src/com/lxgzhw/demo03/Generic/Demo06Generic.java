package com.lxgzhw.demo03.Generic;

import java.util.Collection;

public class Demo06Generic {
    public static void main(String[] args) {

    }
    //泛型的上限:表示只能是该类型或该类型的子类
    static void getElement1(Collection<? extends Number> collection){}
    //泛型的下限:表示只能是该类型或该类型的父类
    static void getElement2(Collection<? super String> collection){}
}
