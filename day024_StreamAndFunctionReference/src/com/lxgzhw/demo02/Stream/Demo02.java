package com.lxgzhw.demo02.Stream;

import java.util.stream.Stream;

/*
Stream流的遍历方法:forEach
    1.参数是一个Consumer接口函数
    2.可以用Lambda表达式优化
    3.可以用引用方法优化
 */
public class Demo02 {
    public static void main(String[] args) {
        Stream<Integer> intList = Stream.of(1, 2, 3, 3, 3, 3, 3, 33333);
        Stream<Integer> intList01 = Stream.of(1, 2, 3, 3, 3, 3, 3, 33333);
        //遍历该流
        intList.forEach(num -> System.out.println(num));
        System.out.println("-------------------------------");
        //方法2 引用给方法优化
        intList01.forEach(System.out::println);
    }
}
