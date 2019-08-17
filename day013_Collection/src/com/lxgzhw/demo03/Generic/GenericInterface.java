package com.lxgzhw.demo03.Generic;

//定义泛型接口
//接收任意数据类型
public interface GenericInterface<E> {
    //方法使用该数据类型
    void method(E i);
}
