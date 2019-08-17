package com.lxgzhw.demo03.Generic;

//泛型接口的另一种实现方法
//泛型类
//泛型类使用什么类型,接口就用什么类型
public class GenericInterfaceImpl2<E> implements GenericInterface<E> {
    @Override
    public void method(E i) {
        System.out.println("泛型类,接收任意数据类型");
        System.out.println(i);
        System.out.println("-------------------------------");
    }
}
