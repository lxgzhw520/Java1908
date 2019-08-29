package com.lxgzhw.demo01.Reflect;

import com.lxgzhw.domain.Person;

import java.lang.reflect.Field;
import java.util.Arrays;
import java.util.stream.Stream;

/*
通过Class对象获取成员变量:
    1.getFields()获取public
    2.getField(成员变量名)
        1.返回成员变量
        2.可以通过成员变量.get(对象名)获取值
        3.可以通过成员变量.set(对象名,值)设置值
    3.getDeclaredFields()获取所有
 */
public class Demo02 {
    public static void main(String[] args) throws NoSuchFieldException, IllegalAccessException {
        //1.获取public成员变量
        Class<Person> personClass = Person.class;
        Field[] fields = personClass.getFields();
        Stream<Field> stream = Arrays.stream(fields);
        stream.forEach(System.out::println);
        System.out.println("-------------------------------");

        //2.获取所有成员变量
        Field[] declaredFields = personClass.getDeclaredFields();
        Stream<Field> stream1 = Arrays.stream(declaredFields);
        stream1.forEach(System.out::println);
        System.out.println("-------------------------------");

        //3.设置反射设置成员变量的值
        Person cuFeng = new Person("楚枫", 22);
        System.out.println(cuFeng);
        //3.1获取楚枫的a成员变量
        Field a = personClass.getDeclaredField("a");
        //3.2设置楚枫的年龄
        a.set(cuFeng, "哈哈哈");
        System.out.println(cuFeng.a);
    }
}
