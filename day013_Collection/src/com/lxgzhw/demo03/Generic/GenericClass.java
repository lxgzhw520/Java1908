package com.lxgzhw.demo03.Generic;
/*
 1.定义一个含有泛型的类
 2.泛型是一个未知的数据类型,当不确定使用什么类型时,可以使用泛型
 3.泛型可以接受任意的数据类型
 4.创建对象的时候确定泛型的数据类型
 */
public class GenericClass<E> {
    private E name;

    public GenericClass() {
    }

    public GenericClass(E name) {
        this.name = name;
    }

    public E getName() {
        return name;
    }

    public void setName(E name) {
        this.name = name;
    }
}
