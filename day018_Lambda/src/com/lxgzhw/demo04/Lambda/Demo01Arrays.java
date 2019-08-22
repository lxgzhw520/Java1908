package com.lxgzhw.demo04.Lambda;

import java.util.Arrays;

public class Demo01Arrays {
    public static void main(String[] args) {
        //使用Lambda表达式简化数组对象排序写法
        //创建三个人的数组
        Person[] arr = {
                new Person("楚枫", 22),
                new Person("萃萃", 18),
                new Person("大黄", 333),
        };
        //按年龄升序
        Arrays.sort(arr, (o1, o2) -> o1.getAge() - o2.getAge());
        //打印
        printArray(arr);
        //按年龄降序
        Arrays.sort(arr, (o1, o2) -> o2.getAge() - o1.getAge());
        printArray(arr);
    }

    private static void printArray(Person[] arr) {
        for (Person person : arr) {
            System.out.println(person);
        }
        System.out.println("-------------------------------");
    }
}
