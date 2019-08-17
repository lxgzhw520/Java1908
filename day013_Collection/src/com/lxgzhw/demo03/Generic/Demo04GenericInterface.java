package com.lxgzhw.demo03.Generic;

public class Demo04GenericInterface {
    public static void main(String[] args) {
        //创建接口实现类1
        GenericInterfaceImpl1 genericInterfaceImpl1 = new GenericInterfaceImpl1();
        genericInterfaceImpl1.method("只能传递字符串");

        //创建接口实现类2 泛型
        GenericInterfaceImpl2<String> stringGenericInterfaceImpl2 = new GenericInterfaceImpl2<>();
        stringGenericInterfaceImpl2.method("传递字符串");
        GenericInterfaceImpl2<Integer> integerGenericInterfaceImpl2 = new GenericInterfaceImpl2<>();
        System.out.println("传递数字");
        integerGenericInterfaceImpl2.method(111);
    }
}
