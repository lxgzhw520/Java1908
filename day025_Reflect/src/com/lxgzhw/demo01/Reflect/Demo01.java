package com.lxgzhw.demo01.Reflect;

import com.lxgzhw.domain.Person;

/*
获取class对象的方式:
    1.Class.forName("全类名")
    2.类名.class
    3.对象.getClass()
 */
public class Demo01 {
    public static void main(String[] args) throws ClassNotFoundException {

        //方法1:通过全类名获取
        Class<?> aClass = Class.forName("com.lxgzhw.domain.Person");
        System.out.println(aClass);
        System.out.println("-------------------------------");

        //方法2:通过类名获取
        Class<Person> personClass = Person.class;
        System.out.println(personClass);
        System.out.println("-------------------------------");

        //方法3:通过实例获取
        Class<? extends Person> aClass1 = new Person().getClass();
        System.out.println(aClass1);
    }
}
