package com.lxgzhw.demo01.Reflect;

import com.lxgzhw.domain.Person;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

/*
反射获取构造方法:
    1.getConstructors 获取公开的
    2.getDeclaredConstructors 获取所有的
 */
public class Demo03 {
    public static void main(String[] args) throws NoSuchMethodException, IllegalAccessException, InvocationTargetException, InstantiationException {
        //获取构造方法1:公开的
        Class<Person> personClass = Person.class;
        Constructor<?>[] constructors = personClass.getConstructors();
        for (Constructor<?> constructor : constructors) {
            System.out.println(constructor);
        }
        System.out.println("-------------------------------");

        //获取构造方法2:所有的
        Constructor<?>[] declaredConstructors = personClass.getDeclaredConstructors();
        for (Constructor<?> declaredConstructor : declaredConstructors) {
            System.out.println(declaredConstructor);
        }
        System.out.println("-------------------------------");

        //通过反射创建对象1:有参构造
        Constructor<Person> constructor = personClass.getConstructor(String.class, int.class);
        Person cuFeng = constructor.newInstance("楚枫", 22);
        System.out.println(cuFeng);
        System.out.println("-------------------------------");

        //通过反射创建对象2:无参构造
        Constructor<Person> constructor1 = personClass.getConstructor();
        Person cuiCui = constructor1.newInstance();
        cuiCui.setName("萃萃");
        cuiCui.setAge(21);
        System.out.println(cuiCui);

    }
}
