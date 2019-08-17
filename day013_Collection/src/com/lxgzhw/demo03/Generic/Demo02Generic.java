package com.lxgzhw.demo03.Generic;


public class Demo02Generic {
    public static void main(String[] args) {
        //不写泛型默认为Object类型
        GenericClass genericClass = new GenericClass();
        genericClass.setName("可以是任意类型");
        System.out.println(genericClass.getName());
        genericClass.setName(111);
        System.out.println(genericClass.getName());
        System.out.println("-------------------------------");

        //使用Integer类,就只能用int类型
        GenericClass<Integer> integerGenericClass = new GenericClass<>();
        integerGenericClass.setName(11111);
        System.out.println(integerGenericClass.getName());
        System.out.println("-------------------------------");

        //使用String类,就只能用String类型
        GenericClass<String> stringGenericClass = new GenericClass<>();
        stringGenericClass.setName("确定为字符串类型");
        System.out.println(stringGenericClass.getName());
        System.out.println("-------------------------------");

    }
}
